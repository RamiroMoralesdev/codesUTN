import random
import colorama
import time
import os 

def limpiar_pantalla():
    os.system('cls' if os.name == 'nt' else 'clear')

# Random.sample(range(inicio, fin), cantidad de elementos) 
listaDeNumerosIntermedia = random.sample(range(1, 51), 50)
listaDeNumerosGigante = random.sample(range(1, 1001), 1000)

# ================================ ALGORITMOS DE ORDENAMIENTO ================================

# Bubble Sort: compara elementos adyacentes y los intercambia si están desordenados
def BubbleSort(lista):
    num = len(lista)
    for i in range(num):
        for j in range(0, num - i - 1):
            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]
    return lista

def InsertionSort(listaGrande): # Ordena insertando cada elemento en su poscicion correcta dentro de una nueva lista ordenada.

    for i in range(1, len(listaGrande)):
        key = listaGrande[i]
        j = i - 1
        while j >= 0 and key < listaGrande[j]:
            listaGrande[j + 1] = listaGrande[j]
            j -= 1
        listaGrande[j + 1] = key
    return listaGrande

def QuickSort(listaGigante): # Ordena dividiendo la lista en sublistas menores y mayores al elemento pivote o elemento central, y luego ordenando esas sublistas recursivamente.

    if len(listaGigante) <= 1:
        return listaGigante
    else:
        elemento_pivot = listaGigante[len(listaGigante) // 2]
        izquierda = [x for x in listaGigante if x < elemento_pivot]
        medio = [x for x in listaGigante if x == elemento_pivot]
        derecha = [x for x in listaGigante if x > elemento_pivot]
        return QuickSort(izquierda) + medio + QuickSort(derecha)

def SelectionSort(lista): # Ordena seleccionando el elemento mas pequeño de la lista y colocandolo al principio, Es recursivo hasta completar la lista.

    for i in range(len(lista)):
        min_idx = i
        for j in range(i + 1, len(lista)):
            if lista[j] < lista[min_idx]:
                min_idx = j
        lista[i], lista[min_idx] = lista[min_idx], lista[i]
    return lista

 

sorted_list = sorted(listaDeNumerosGigante)  # Ordena la lista gigante de numeros

# ================================ ALGORITMOS DE BUSQUEDA =======================================

# Búsqueda Binaria: requiere lista ordenada, divide el rango de búsqueda a la mitad
def BusquedaBinaria(lista, objetivo):
    izquierda, derecha = 0, len(lista) - 1
    while izquierda <= derecha:
        medio = (izquierda + derecha) // 2
        if lista[medio] == objetivo:
            return medio
        elif lista[medio] < objetivo:
            izquierda = medio + 1
        else:
            derecha = medio - 1
    return -1  # Si no lo encuentra


def BusquedaLineal(lista, objetivo): # Bucle for que recorre la cada elemento de la lista y compara si es igual al objetivo.

    for i in range(len(lista)):
        if lista[i] == objetivo:
            return i
    return -1  # Si no lo encuentra


def menu():
    while True:
        limpiar_pantalla()

        print("1. Ordenar lista de numeros con Bubble Sort")
        print("2. Ordenar lista grande de numeros con Insertion Sort")
        print("3. Ordenar lista gigante de numeros con Quick Sort")
        print("4. Ordenar lista de numeros enana con Selection Sort")
        print("5. Buscar un numero en la lista ordenada con Bubble Sort y Busqueda Binaria")
        print("6. Buscar un numero en la lista ordenada con Selection Sort y Busqueda Lineal")
        print("7. Ordenar con funcion integrada de Python (sorted)")
        print("8. Salir")
        opcion = input("Seleccione una opcion: ")
        if opcion == "8":
            print(colorama.Fore.CYAN + "Saliendo del programa...")
            break

        limpiar_pantalla()  # Limpiar después de seleccionar cada opción
        
        inicio = time.time()  

        if opcion == "1":
            print(colorama.Fore.RED + "Lista ordenada con Bubble Sort:", BubbleSort(listaDeNumerosGigante))
            nombreAlgoritmo = "Bubble Sort"

        elif opcion == "2":
            print(colorama.Fore.YELLOW + f"Lista grande ordenada con Insertion Sort:", InsertionSort(listaDeNumerosGigante))
            nombreAlgoritmo = "Insertion Sort"

        elif opcion == "3":
            print(colorama.Fore.YELLOW + f"Lista gigante ordenada con Quick Sort: {QuickSort(listaDeNumerosGigante)}")
            nombreAlgoritmo = "Quick Sort"

        elif opcion == "4":
            print(colorama.Fore.MAGENTA + f"Lista de numeros ordenada con Selection Sort: {SelectionSort(listaDeNumerosGigante)}")
            nombreAlgoritmo = "Selection Sort"

        elif opcion == "5":
            numeroObjetivo = int(input("Ingrese un numero entre 1 y 50: "))
            posicion = BusquedaBinaria(BubbleSort(listaDeNumerosIntermedia), numeroObjetivo)
            if posicion != -1:
                print(f"Posicion del numero {numeroObjetivo} en la lista ordenada con Bubble Sort Y Busqueda Binaria: {posicion}")
                nombreAlgoritmo = "Bubble Sort y Busqueda Binaria"
            else:
                print(f"El numero {numeroObjetivo} no se encuentra en la lista.")
            

        elif opcion == "6":
            numeroObjetivoLineal = int(input("Ingrese un numero entre 1 y 50: "))
            posicion = BusquedaLineal(SelectionSort(listaDeNumerosIntermedia), numeroObjetivoLineal)
            if posicion != -1:
                print(f"Posicion del numero {numeroObjetivoLineal} en la lista ordenada con Selection Sort Y Busqueda Lineal: {posicion}") 
                nombreAlgoritmo = "Selection Sort y Busqueda Lineal"
            else:
                print(f"El numero {numeroObjetivoLineal} no se encuentra en la lista.")

        elif opcion == "7":
            print(colorama.Fore.GREEN + f"Lista gigante ordenada con la funcion integrada de Python (sorted): {sorted_list}")
            nombreAlgoritmo = "Funcion integrada de Python (sorted)"

        fin = time.time()
        duracion = fin - inicio

        print(colorama.Fore.BLUE + "Algoritmo usado: " + nombreAlgoritmo)
        print(colorama.Fore.BLUE + f"Tiempo de ejecucion: {duracion:.4f} segundos")

        input("\nPresione Enter para volver al menú...")

menu() 