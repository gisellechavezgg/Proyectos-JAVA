import numpy as np
import matplotlib.pyplot as plt
import random
import math

def costo_ruta(ruta, dist):
    return sum(dist[ruta[i-1]][ruta[i]] for i in range(len(ruta)))

# Recocido: a veces acepta rutas peores para no quedarse ciclado
def recocido(ruta_ini, dist, tipo_enfriamiento='exp'):
    ruta_actual = ruta_ini.copy()
    costo_act = costo_ruta(ruta_actual, dist)
    
    temp = 1000.0
    temp_min = 1.0
    historial = []
    
    while temp > temp_min:
        # Swap de 2 nodos random (vecindario)
        i, j = sorted(random.sample(range(1, len(ruta_actual)), 2))
        ruta_vec = ruta_actual[:i] + ruta_actual[i:j][::-1] + ruta_actual[j:]
        costo_vec = costo_ruta(ruta_vec, dist)
        
        diferencia = costo_vec - costo_act
        
        # Si es mejor, la toma. Si es peor, la toma con cierta probabilidad
        if diferencia < 0 or random.random() < math.exp(-diferencia / temp):
            ruta_actual = ruta_vec
            costo_act = costo_vec
            
        historial.append(costo_act)
        
        # Enfriamos
        if tipo_enfriamiento == 'exp':
            temp *= 0.99  # Baja despacito
        else:
            temp -= 1     # Baja de golpe
            
    return historial

np.random.seed(10)
random.seed(10)
coords = np.random.rand(30, 2) * 100
distancias = np.linalg.norm(coords[:, np.newaxis] - coords, axis=2)

ruta_base = list(range(30))
random.shuffle(ruta_base)

hist_exp = recocido(ruta_base, distancias, 'exp')
hist_lin = recocido(ruta_base, distancias, 'lineal')

plt.plot(hist_exp, label='Exponencial (Lento pero seguro)', color='purple')
plt.plot(hist_lin, label='Lineal (Rápido pero chafa)', color='green')
plt.title('Ej 4: Convergencia Recocido Simulado')
plt.xlabel('Iteración')
plt.ylabel('Costo (Distancia)')
plt.legend()
plt.grid()
plt.savefig('ej4_recocido.png')
plt.show()