# Ej 1
for i in range(0, 101):
    print(i)

# EJ 2
num = input("Ingrese un número entero: ")
print(len(num))

# EJ 3
numerouno = int(input("Ingrese el primer número: "))
numerodos = int(input("Ingrese el segundo número: "))

sumatoria = 0

for x in range(numerouno, numerodos + 1):
    sumatoria += x

print(f"La sumatoria de los números entre {numerouno} y {numerodos} es: {sumatoria}")

# EJ 4
contador = 0 
while True:
    entero = int(input("Ingrese un número a acumular: Presiona 0 para salir:"))
    contador  += entero
    
    if entero == 0:
        print(f"Acumulado: {contador}")
        break

# EJ 5
import random

# Generar un número aleatorio entre 0 y 9
numero_secreto = random.randint(0, 9)
intentos = 0

print("Adiviná el número (entre 0 y 9). ")

while True:
    intento = int(input("Tu intento: "))
    intentos += 1

    if intento == numero_secreto:
        print(f"¡Correcto! Adivinaste el número en {intentos} intento(s).")
        break
    else:
        pass

# EJ 6
for a in range(100, -1, -1):
    if a % 2 == 0:
        print(a)
    else:
        pass
 

 # EJ 7
num_uno = int(input("Ingrese un número entero positivo: "))

resultado = 0

if num_uno <= 0:
    print("Debe ingresar un número positivo.")
else:
    for x in range(0, num_uno):  # de 0 hasta num_uno sin incluirlo
        resultado += x

    print(f"La sumatoria de los números entre 0 y {num_uno} (sin incluirlo) es: {resultado}")


# EJ 8 

CANTIDAD_NUMEROS = 5 # Para ajustar la cantidad de iteraciones en el for. Cambiar el valor de esta variable

pares = 0
impares = 0
positivos = 0
negativos = 0

print(f"Ingresá {CANTIDAD_NUMEROS} números enteros:")

for i in range(CANTIDAD_NUMEROS):
    numero = int(input(f"Número {i + 1 }: ")) # Se le agrega + 1 al i porque la iteración comienza en 0

    
    if numero % 2 == 0:
        pares += 1
    else:
        impares += 1

    
    if numero > 0:
        positivos += 1
    elif numero < 0:
        negativos += 1


print("Resultados:")
print(f"Cantidad de números pares: {pares}")
print(f"Cantidad de números impares: {impares}")
print(f"Cantidad de números positivos: {positivos}")
print(f"Cantidad de números negativos: {negativos}")


# EJ 9
cant_numeros = 5 # Para ajustar la cantidad de iteraciones en el for. Cambiar el valor de esta variable
suma = 0

for i in range(cant_numeros):
    numerito = int(input(f"Número {i + 1}: "))
    suma += numerito

media = suma / cant_numeros
print(f"La media es: {media}")


# EJ 10
original = (input("Ingrese un numero a invertir: "))

invertir = int(original[::-1])

print(f"El numero invertido de {original} es {invertir}")


print("Gracias por ejecutar mi codigo")