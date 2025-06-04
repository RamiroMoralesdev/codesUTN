import random
import colorama
import time
import os  # Usado para limpiar la consola según el sistema operativo

# ================================ GENERACIÓN DE LISTAS ALEATORIAS ================================
# Generamos listas con números aleatorios de diferentes tamaños
listaDeNumerosEnana = random.sample(range(1, 11), 10)
listaDeNumeros = random.sample(range(1, 51), 50)
listaDeNumerosGrande = random.sample(range(1, 201), 200)
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

# Insertion Sort: inserta cada elemento en su lugar correcto dentro de la parte ya ordenada
def InsertionSort(listaGrande):
    for i in range(1, len(listaGrande)):
        key = listaGrande[i]
        j = i - 1
        while j >= 0 and key < listaGrande[j]:
            listaGrande[j + 1] = listaGrande[j]
            j -= 1
        listaGrande[j + 1] = key
    return listaGrande

# Quick Sort: divide la lista en sublistas menores/mayores a un pivote y las ordena recursivamente
def QuickSort(listaGigante):
    if len(listaGigante) <= 1:
        return listaGigante
    else:
        elemento_pivot = listaGigante[len(listaGigante) // 2]
        izquierda = [x for x in listaGigante if x < elemento_pivot]
        medio = [x for x in listaGigante if x == elemento_pivot]
        derecha = [x for x in listaGigante if x > elemento_pivot]
        return QuickSort(izquierda) + medio + QuickSort(derecha)

# Selection Sort: busca el menor elemento y lo coloca al principio de la lista
def SelectionSort(lista):
    for i in range(len(lista)):
        min_idx = i
        for j in range(i + 1, len(lista)):
            if lista[j] < lista[min_idx]:
                min_idx = j
        lista[i], lista[min_idx] = lista[min_idx], lista[i]
    return lista

# ================================ PRUEBAS INICIALES ================================

# Prueba Bubble Sort
print("================= ALGORITMO BUBBLE SORT =================")
print(colorama.Fore.BLUE + "Lista de numeros aleatorios sin ordenar:", listaDeNumeros)
print(colorama.Fore.RED + "Lista ordenada con Bubble Sort:", BubbleSort(listaDeNumeros))

# Prueba Insertion Sort
print("================= ALGORITMO INSERTION SORT =================")
print(colorama.Fore.GREEN + f"Lista grande de numeros aleatorios sin ordenar:", listaDeNumerosGrande)
print(colorama.Fore.YELLOW + f"Lista grande ordenada con Insertion Sort:", InsertionSort(listaDeNumerosGrande))

# Prueba Quick Sort
print("================= ALGORITMO QUICK SORT =================")
print(colorama.Fore.GREEN + f"Lista gigante de numeros aleatorios sin ordenar: {listaDeNumerosGigante}")
print(colorama.Fore.YELLOW + f"Lista gigante ordenada con Quick Sort: {QuickSort(listaDeNumerosGigante)}")

# Prueba Selection Sort
print("================= ALGORITMO SELECTION SORT =================")
print(colorama.Fore.CYAN + f"Lista de numeros aleatorios sin ordenar: {listaDeNumerosEnana}")
print(colorama.Fore.MAGENTA + f"Lista de numeros ordenada con Selection Sort: {SelectionSort(listaDeNumerosEnana)}")

# Prueba función sorted() de Python (muy eficiente)
print("================= ALGORITMO sorted() =================")
listaOrdenada = sorted(listaDeNumeros)
print(colorama.Fore.YELLOW + f"Lista de numeros ordenada con la funcion sorted(): {listaOrdenada}")

# ================================ ALGORITMOS DE BÚSQUEDA ================================
#print(colorama.Fore.BLUE + "Algoritmos de busqueda")

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

# Búsqueda Lineal: recorre la lista uno por uno hasta encontrar el elemento
def BusquedaLineal(lista, objetivo):
    for i in range(len(lista)):
        if lista[i] == objetivo:
            return i
    return -1  # Si no lo encuentra

# Entrada del usuario para probar búsqueda binaria
#numeroObjetivo = int(input("Ingrese un numero entre 1 y 50: "))
#print(f"Posicion del numero {numeroObjetivo} en la lista ordenada con Bubble Sort Y Busqueda Binaria:", 
#BusquedaBinaria(BubbleSort(listaDeNumeros), numeroObjetivo))

# Entrada del usuario para probar búsqueda lineal
#numeroObjetivoLineal = int(input("Ingrese un numero entre 1 y 10: "))
#print(f"Posicion del numero {numeroObjetivoLineal} en la lista ordenada con Selection Sort Y Busqueda Lineal:", 
#BusquedaLineal(SelectionSort(listaDeNumerosEnana), numeroObjetivoLineal))

# ================================ MENÚ FINAL CON MEDICIÓN DE TIEMPO ================================

while True:
    os.system("cls" if os.name == "nt" else "clear")

    print(colorama.Fore.BLUE + "\n====== Menú de comparación de algoritmos ======")
    print("1. Bubble Sort")
    print("2. Insertion Sort")
    print("3. Quick Sort")
    print("4. Selection Sort")
    print("5. sorted() (función incorporada de Python)")
    print("6. Pruebas de búsqueda (Binaria y Lineal)")
    print("7. Salir")

    opcion = input("Elige una opción: ")

    if opcion == "7":
        print(colorama.Fore.RED + "Saliendo del programa...")
        break

    # Nueva lista aleatoria para pruebas de ordenamiento
    listaBase = random.sample(range(1, 501), 500)

    # Búsquedas
    if opcion == "6":
        os.system("cls" if os.name == "nt" else "clear")

        print(colorama.Fore.YELLOW + "\n--- Búsqueda Binaria ---")
        listaOrdenada = BubbleSort(listaDeNumeros.copy())
        try:
            numeroObjetivo = int(input("Ingrese un número entre 1 y 50: "))
            posicion = BusquedaBinaria(listaOrdenada, numeroObjetivo)
            print(f"Número {numeroObjetivo} encontrado en la posición {posicion}" if posicion != -1 else "Número no encontrado")
        except:
            print("Entrada inválida.")

        print(colorama.Fore.CYAN + "\n--- Búsqueda Lineal ---")
        listaOrdenada2 = SelectionSort(listaDeNumerosEnana.copy())
        try:
            numeroObjetivoLineal = int(input("Ingrese un número entre 1 y 10: "))
            posicion2 = BusquedaLineal(listaOrdenada2, numeroObjetivoLineal)
            print(f"Número {numeroObjetivoLineal} encontrado en la posición {posicion2}" if posicion2 != -1 else "Número no encontrado")
        except:
            print("Entrada inválida.")

        input(colorama.Fore.WHITE + "\nPresiona Enter para volver al menú...")
        continue

    # Algoritmos de ordenamiento
    inicio = time.time()

    if opcion == "1":
        resultado = BubbleSort(listaBase.copy())
        nombre = "Bubble Sort"
    elif opcion == "2":
        resultado = InsertionSort(listaBase.copy())
        nombre = "Insertion Sort"
    elif opcion == "3":
        resultado = QuickSort(listaBase.copy())
        nombre = "Quick Sort"
    elif opcion == "4":
        resultado = SelectionSort(listaBase.copy())
        nombre = "Selection Sort"
    elif opcion == "5":
        resultado = sorted(listaBase.copy())
        nombre = "sorted()"
    else:
        print("Opción no válida. Presiona Enter para continuar.")
        input()
        continue

    fin = time.time()
    duracion = fin - inicio

    print(colorama.Fore.CYAN + f"\nAlgoritmo usado: {nombre}")
    print(colorama.Fore.GREEN + f"Primeros 20 números ordenados: {resultado[:20]} ...")
    print(colorama.Fore.MAGENTA + f"Tiempo de ejecución: {duracion:.6f} segundos")

    input(colorama.Fore.WHITE + "\nPresiona Enter para volver al menú...")
