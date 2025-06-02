import random
import colorama

# Random.sample(range(inicio, fin), cantidad de elementos) 
listaDeNumerosEnana = random.sample(range(1, 11), 10)
listaDeNumeros = random.sample(range(1, 51), 50)
listaDeNumerosGrande = random.sample(range(1, 201), 200)
listaDeNumerosGigante = random.sample(range(1, 1001), 1000)
# print("Lista de numeros aleatorios:", listaDeNumeros)

def BubbleSort(lista): # Ordena comparando dos elementos adyacentes o el que tiene al lado y los pone en la posicion correcta.
    num = len(lista)
    for i in range(num):
        for j in range(0, num-i-1):
            if lista[j] > lista[j+1]:
                lista[j], lista[j+1] = lista[j+1], lista[j]
    return lista
print(colorama.Fore.BLUE + "Lista de numeros aleatorios sin ordenar:", listaDeNumeros)
print(colorama.Fore.RED + "Lista ordenada con Bubble Sort:", BubbleSort(listaDeNumeros))


def InsertionSort(listaGrande): # Ordena insertando cada elemento en su poscicion correcta dentro de una nueva lista ordenada.
    for i in range(1, len(listaGrande)):
        key = listaGrande[i]
        j = i-1
        while j >=0 and key < listaGrande[j] :
            listaGrande[j+1] = listaGrande[j]
            j -= 1
        listaGrande[j+1] = key
    return listaGrande


print(colorama.Fore.GREEN + f"Lista grande de numeros aleatorios sin ordenar:", listaDeNumerosGrande)
print(colorama.Fore.YELLOW + f"Lista grande ordenada con Insertion Sort:", InsertionSort(listaDeNumerosGrande))

def QuickSort(listaGigante): # Ordena dividiendo la lista en sublistas menores y mayores al elemento pivote o elemento central, y luego ordenando esas sublistas recursivamente.
    if len(listaGigante) <= 1:
        return listaGigante
    else:
        elemento_pivot = listaGigante[len(listaGigante) // 2]
        izquierda = [x for x in listaGigante if x < elemento_pivot]
        medio = [x for x in listaGigante if x == elemento_pivot]
        derecha = [x for x in listaGigante if x > elemento_pivot]
        return QuickSort(izquierda) + medio + QuickSort(derecha)
    
print(colorama.Fore.GREEN + f"Lista gigante de numeros aleatorios sin ordenar: {listaDeNumerosGigante}")
print(colorama.Fore.YELLOW + f"Lista gigante ordenada con Quick Sort: {QuickSort(listaDeNumerosGigante)}")


def SelectionSort(lista): # Ordena seleccionando el elemento mas pequeño de la lista y colocandolo al principio, Es recursivo hasta completar la lista.
    for i in range(len(lista)):
        min_idx = i
        for j in range(i+1, len(lista)):
            if lista[j] < lista[min_idx]:
                min_idx = j
        lista[i], lista[min_idx] = lista[min_idx], lista[i]
    return lista

print(colorama.Fore.CYAN + f"Lista de numeros aleatorios sin ordenar: {listaDeNumerosEnana}")
print(colorama.Fore.MAGENTA + f"Lista de numeros ordenada con Selection Sort: {SelectionSort(listaDeNumerosEnana)}")


listaOrdenada = sorted(listaDeNumeros) # Sorted es una funcion para ordenar listas mucho mas rapido.
print(colorama.Fore.YELLOW + f"Lista de numeros ordenada con la funcion sorted(): {listaOrdenada}")

# ================================ ALGORITMOS DE BUSQUEDA =======================================
print(colorama.Fore.BLUE + "Algoritmos de busqueda")

def BusquedaBinaria(lista, objetivo): # Requiere que la lista este ordenada previamente. Divide la lista en 2 y busca el objetivo.
    izquierda, derecha = 0, len(lista) - 1

    while izquierda <= derecha:
        medio = (izquierda + derecha) // 2
        if lista[medio] == objetivo:
            return medio
        elif lista[medio] < objetivo:
            izquierda = medio + 1
        else:
            derecha = medio - 1
    return -1

numeroObjetivo = int(input("Ingrese un numero entre 1 y 50: "))

print(f"Posicion del numero {numeroObjetivo} en la lista ordenada con Bubble Sort Y Busqueda Binaria:", BusquedaBinaria(BubbleSort(listaDeNumeros), numeroObjetivo))

def BusquedaLineal(lista, objetivo): # Bucle for que recorre la cada elemento de la lista y compara si es igual al objetivo.
    for i in range(len(lista)):
        if lista[i] == objetivo:
            return i
    return -1

numeroObjetivoLineal = int(input("Ingrese un numero entre 1 y 10: "))
print(f"Posicion del numero {numeroObjetivoLineal} en la lista ordenada con Selection Sort Y Busqueda Lineal:", BusquedaLineal(SelectionSort(listaDeNumerosEnana), numeroObjetivoLineal))

