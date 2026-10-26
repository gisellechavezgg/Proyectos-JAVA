import numpy as np
import matplotlib.pyplot as plt
import random

# Saca el costo total sumando las distancias de la ruta
def costo_ruta(ruta, dist):
    return sum(dist[ruta[i-1]][ruta[i]] for i in range(len(ruta)))

# Heurística para armar una ruta inicial decente
def vecino_cercano(dist):
    n = len(dist)
    faltan = set(range(1, n))
    ruta = [0]
    actual = 0
    while faltan:
        # Buscamos el nodo más cerca que no hayamos visitado
        sig = min(faltan, key=lambda x: dist[actual][x])
        ruta.append(sig)
        faltan.remove(sig)
        actual = sig
    return ruta

# 2-opt: va desentrelazando cruces en la ruta
def optimiza_2opt(ruta, dist):
    mejor_ruta = ruta.copy()
    mejor_costo = costo_ruta(ruta, dist)
    iteraciones = 0
    hubo_mejora = True
    
    while hubo_mejora:
        hubo_mejora = False
        # Checamos todas las combinaciones de aristas
        for i in range(1, len(ruta) - 2):
            for j in range(i + 1, len(ruta)):
                if j - i == 1: continue # Si están pegadas no se cruzan
                
                # Volteamos el pedazo de ruta (swap 2-opt)
                ruta_nueva = mejor_ruta[:i] + mejor_ruta[i:j][::-1] + mejor_ruta[j:]
                costo_nuevo = costo_ruta(ruta_nueva, dist)
                
                if costo_nuevo < mejor_costo:
                    mejor_costo = costo_nuevo
                    mejor_ruta = ruta_nueva
                    iteraciones += 1
                    hubo_mejora = True
                    
    return mejor_ruta, mejor_costo, iteraciones

# Simulamos 30 ciudades al azar
np.random.seed(42)
coords = np.random.rand(30, 2) * 100
distancias = np.linalg.norm(coords[:, np.newaxis] - coords, axis=2)

# Prueba 1: Ruta a lo loco
ruta_random = list(range(30))
random.shuffle(ruta_random)
_, _, iters_random = optimiza_2opt(ruta_random, distancias)

# Prueba 2: Ruta inteligente (Vecino cercano)
ruta_nn = vecino_cercano(distancias)
_, _, iters_nn = optimiza_2opt(ruta_nn, distancias)

# Gráfica
plt.bar(['Random', 'Vecino Cercano'], [iters_random, iters_nn], color=['orange', 'teal'])
plt.title('Ej 3: Cuántas mejoras ocupó 2-opt')
plt.ylabel('Iteraciones de mejora')
plt.savefig('ej3_2opt.png')
plt.show()