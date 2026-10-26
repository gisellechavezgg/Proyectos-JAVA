import matplotlib.pyplot as plt

# La vieja confiable: ordenamos y metemos hasta que se llene
def mochila_greedy(objetos, max_peso, usar_ratio=False):
    # Si usar_ratio es True, ordena por V/W. Si no, por el más ligero primero.
    if usar_ratio:
        objs = sorted(objetos, key=lambda x: x['val'] / x['peso'], reverse=True)
    else:
        objs = sorted(objetos, key=lambda x: x['peso'])
    
    peso_usado = 0
    ganancia = 0
    llevamos = []

    for obj in objs:
        if peso_usado + obj['peso'] <= max_peso:
            peso_usado += obj['peso']
            ganancia += obj['val']
            llevamos.append(obj['id'])
            
    return ganancia, llevamos

# Mi contraejemplo para el reporte:
capacidad = 10
cosas = [
    {'id': 'Piedrita (Pesa poco, vale poco)', 'peso': 2, 'val': 3},
    {'id': 'Oro (Pesa casi todo, vale mucho)', 'peso': 9, 'val': 90}
]

# Probamos ambos enfoques
ganancia_peso, items_peso = mochila_greedy(cosas, capacidad, usar_ratio=False)
ganancia_ratio, items_ratio = mochila_greedy(cosas, capacidad, usar_ratio=True)

print(f"Criterio 'Más ligero': Ganamos {ganancia_peso}. Llevamos: {items_peso}")
print(f"Criterio 'Valor/Peso': Ganamos {ganancia_ratio}. Llevamos: {items_ratio}")

# Gráfica de barras sencilla
plt.bar(['Menor Peso', 'Mejor Ratio (V/W)'], [ganancia_peso, ganancia_ratio], color=['#ff9999','#99ff99'])
plt.title('Ej 2: Por qué ordenar por peso falla')
plt.ylabel('Ganancia total')
for i, v in enumerate([ganancia_peso, ganancia_ratio]):
    plt.text(i, v + 2, f"${v}", ha='center')
plt.savefig('ej2_mochila.png')
plt.show()