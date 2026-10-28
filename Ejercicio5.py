import numpy as np
import networkx as nx
import matplotlib.pyplot as plt
import itertools

def costo_ruta(ruta, dist):
    return sum(dist[ruta[i-1]][ruta[i]] for i in range(len(ruta)))

# Ojo: la fuerza bruta explota si le pones más de 10 ciudades, por eso n=9
def saca_optimo(dist):
    n = len(dist)
    mejor = float('inf')
    # Fijamos el 0 al inicio para no repetir ciclos
    for perm in itertools.permutations(range(1, n)):
        ruta = [0] + list(perm)
        costo = costo_ruta(ruta, dist)
        if costo < mejor:
            mejor = costo
    return mejor

# Usamos networkx para armar el MST rápido y luego recorrerlo en preorden
def aprox_mst(dist):
    G = nx.Graph()
    n = len(dist)
    for i in range(n):
        for j in range(i+1, n):
            G.add_edge(i, j, weight=dist[i][j])
            
    mst = nx.minimum_spanning_tree(G)
    # Recorrido de los nodos sin repetir
    ruta = list(nx.dfs_preorder_nodes(mst, source=0))
    return ruta, costo_ruta(ruta, dist)

# Simulamos 100 veces para graficar
N_CASOS = 100
N_CIUDADES = 9
razones = []

print("Corriendo 100 instancias, dame un segundo...")

for _ in range(N_CASOS):
    coords = np.random.rand(N_CIUDADES, 2) * 100
    dist = np.linalg.norm(coords[:, np.newaxis] - coords, axis=2)
    
    optimo = saca_optimo(dist)
    _, costo_mst = aprox_mst(dist)
    
    # Qué tan lejos nos quedamos del óptimo
    razones.append(costo_mst / optimo)

plt.hist(razones, bins=15, color='skyblue', edgecolor='black')
plt.axvline(x=2.0, color='red', linestyle='--', label='Límite Teórico (2.0)')
plt.axvline(x=np.mean(razones), color='green', linestyle='--', label=f'Media: {np.mean(razones):.2f}')
plt.title('Ej 5: Razón de Aproximación MST vs Óptimo')
plt.xlabel('Costo MST / Costo Óptimo')
plt.legend()
plt.savefig('ej5_aprox_mst.png')
plt.show()