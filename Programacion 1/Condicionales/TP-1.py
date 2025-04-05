# ej 1
edadUsuario = int(input("Ingrese su edad: "))

if edadUsuario >= 18:
    print("Usted es mayor de edad")
else: 
    print("Usted es menor de edad")

# ej 2

nota = int(input("Ingrese su nota: "))

if nota >= 6:
    print("Aprobado")
else: 
    print("Reprobado")

# ej 3
numero = int(input("Ingrese un número par: "))

if numero % 2 == 0:
    print("El número es par")
else: 
    print("El número es impar")

# ej 4 

edadCategoria = int(input("Ingrese su edad: "))

if edadCategoria < 12:
    print("Niño")
elif edadCategoria >= 12 and edadCategoria < 18:
        print("Adolescente")
elif edadCategoria >= 18 and edadCategoria < 30:
    print("Joven")
else: 
    print("Adulto")

# ej 5 

password = input("Ingrese una password de 8 a 14 caracteres: ")

if 8 <= len(password) <= 14:
    print("Cantidad de caracteres correctos")
else: 
    print("Cantidad de caracteres incorrectos")

# ej 6  
from statistics import mode, median, mean
import random

numeros_aleatorios = [random.randint(1, 100) for i in range(50)]

media = mean(numeros_aleatorios)
mediana = median(numeros_aleatorios)
moda = mode(numeros_aleatorios)

# 3. Determinar el sesgo
if media > mediana > moda:
    print("Sesgo positivo (a la derecha)")
elif media < mediana < moda:
    print("Sesgo negativo (a la izquierda)")
elif media == mediana == moda:
    print("No hay sesgo")
else:
    print("No se puede determinar el sesgo")


print(f"Media: {media}")
print(f"Mediana: {mediana}")
print(f"Moda: {moda}")


# ej 7
vowels = ["a", "e", "i", "o", "u"]

palabra = input("Ingrese una palabra: ")

if palabra[-1].lower() in vowels:
        palabra = palabra + "!"
        
print(palabra)


# ej 8
nombre = input("Ingrese su nombre: ")
opcion = input ("Ingrese una opción: 1,2 o 3 ")
 

if opcion == "1": 
    print(nombre.upper())
elif opcion == "2":
    print(nombre.lower())
elif opcion == "3":
    print(nombre.title())
else:
    print("Opción no válida")


# ej 9 
magnitud = int(input("Ingrese la magnitud del terremoto: "))

if magnitud < 3:
    print("Muy Leve")
elif magnitud >= 3 and magnitud < 4:
    print("Leve")
elif magnitud >= 4 and magnitud < 5:
    print("Moderado")
elif magnitud >= 5 and magnitud < 6:
    print("Fuerte")
elif magnitud >= 6 and magnitud < 7:
    print("Muy fuerte")
elif magnitud >= 7:
    print("Extremo")
else: 
    print("MAGNITUD INCORRECTA")


# ej 10


hemisferio = input("¿En qué hemisferio estás? (N/S): ").upper()
mes = int(input("¿Qué mes es? (1-12): "))
dia = int(input("¿Qué día es? (1-31): "))

# Convertimos la fecha a una tupla para facilitar la comparación
fecha = (mes, dia)

# Definimos estaciones según la tabla
if (fecha >= (12, 21) or fecha <= (3, 20)):
    estacion_norte = "Invierno"
    estacion_sur = "Verano"
elif (fecha >= (3, 21) and fecha <= (6, 20)):
    estacion_norte = "Primavera"
    estacion_sur = "Otoño"
elif (fecha >= (6, 21) and fecha <= (9, 20)):
    estacion_norte = "Verano"
    estacion_sur = "Invierno"
else:  # del 21 de septiembre al 20 de diciembre
    estacion_norte = "Otoño"
    estacion_sur = "Primavera"


if hemisferio == "N":
    print("Estás en", estacion_norte)
elif hemisferio == "S":
    print("Estás en", estacion_sur)
else:
    print("Hemisferio inválido. Debe ser N o S.")
