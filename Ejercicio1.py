import multiprocessing as mp
import time
import random
import matplotlib.pyplot as plt

# Función que tira los dardos. Se va a correr en varios núcleos.
def tira_dardos(n_dardos):
    adentro = 0
    for _ in range(n_dardos):
        x, y = random.random(), random.random()
        if x**2 + y**2 <= 1.0:
            adentro += 1
    return adentro

if __name__ == '__main__':
    # Ojo: el if __name__ es de ley en Windows para que jale multiprocessing
    total_dardos = 10_000_000
    procesos = [1, 2, 4, 8]
    tiempos = []

    print(f"Simulando con {total_dardos} dardos. Aguanta un rato...")
    
    for p in procesos:
        dardos_por_hilo = total_dardos // p
        
        inicio = time.time()
        with mp.Pool(p) as pool:
            # Mandamos la carga dividida a los núcleos
            resultados = pool.map(tira_dardos, [dardos_por_hilo] * p)
            
        # Fórmula de Monte Carlo
        pi_estimado = (4.0 * sum(resultados)) / total_dardos
        fin = time.time()
        
        tiempo_total = fin - inicio
        tiempos.append(tiempo_total)
        print(f"{p} proceso(s) | Tiempo: {tiempo_total:.4f} s | Pi: {pi_estimado:.5f}")

    # Sacamos el speedup dividiendo el tiempo secuencial (1 proceso) entre los demás
    t1 = tiempos[0]
    speedups = [t1 / t for t in tiempos]

    # Gráfica
    plt.plot(procesos, speedups, marker='o', label='Speedup Real', color='blue')
    plt.plot(procesos, procesos, linestyle='--', color='red', label='Speedup Ideal')
    plt.title('Ej 1: Speedup vs Procesos')
    plt.xlabel('Núcleos usados')
    plt.ylabel('Aceleración')
    plt.legend()
    plt.grid()
    plt.savefig('ej1_speedup.png')
    plt.show()