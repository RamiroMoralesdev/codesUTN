# EJ 1
# Definicion de Funciones
def imprimir_hola():
    print("Hola Mundo!")

# Programa principal
imprimir_hola()

# EJ 2
# Definicion de Funciones
def saludar_usuario(nombre):
    print(f"Hola, Como estas, {nombre}")

# Programa principal
nombre = input("Ingrese su nombre: ")
saludar_usuario(nombre)

# EJ 3
# Definicion de Funciones
def informacion_personal(nombre, apellido, edad, ciudad):
    print(f"Mi nombre es {nombre} {apellido}, tengo {edad} años y vivo en {ciudad}")

# Programa principal
nombre = input("Ingrese su nombre: ")
apellido = input("Ingrese su apellido: ")
edad = input("Ingrese su edad: ")
ciudad = input("Ingrese su ciudad: ")

informacion_personal(nombre, apellido, edad, ciudad)


# EJ 4
# Definicion de Funciones
def calcular_area_circulo(radio):
    pi = 3.1416
    area = pi * float(radio) ** 2
    return area
def calcular_perimetro_circulo(radio):
    pi = 3.1416
    perimetro = 2 * pi * float(radio)
    return perimetro

# Programa Principal
radio = input("Ingrese el radio del circulo: ")

area = calcular_area_circulo(radio)
perimetro = calcular_perimetro_circulo(radio)

print(f"El area del circulo es: {area} y su perimetro es: {perimetro}")


# EJ 5 
# Definicion de Funciones
def segundos_a_horas(segundos): 
    horas = int(segundos) / 3600
    return horas

# Programa Principal
segundos = input("Ingrese la cantidad de segundos para calcular las horas: ")

horas = segundos_a_horas(segundos)
print(f"Las horas en {segundos} segundos, equivalentes son: {horas}")


# EJ 6
# Definicion de Funciones
def tabla_de_multiplicar(numero):
    for i in range(1, 11):
        print(f"{numero} x {i} = {numero * i}")

# Programa Principal
numero = int(input("Ingrese un numero para ver su tabla de multiplicar: "))

tabla =  tabla_de_multiplicar(numero)

print(tabla)


# EJ 7
# Definicion de Funciones
def operaciones_basicas(a,b):
    multiplicar = a * b
    dividir = a / b
    sumar = a + b
    restar = a - b

    return f"Multiplicar: {multiplicar}\nDividir: {dividir}\nSumar: {sumar}\nRestar: {restar}"

# Programa Principal
a = int(input("Ingrese el primer numero: "))
b = int(input("Ingrese el segundo numero: "))

operaciones = operaciones_basicas(a,b)
print(operaciones)



# EJ 8
# Definicion de Funciones
def calcular_IMC(peso, altura):
    masaCorporal = peso / (altura ** 2)
    return masaCorporal

# Programa Principal
peso = int(input("Ingrese su peso en kilogramos: "))
altura = int(input("Ingrese su altura en metros: "))

masaCorporal = calcular_IMC(peso, altura)

print(f"Su índice de masa corporal (IMC) es: {masaCorporal}")


# EJ 9 
# Definicion de Funciones
def celsius_a_fahrenheit(celsius):
    fahrenheit = (9/5) * (celsius + 32)
    return fahrenheit

# Programa Principal
celsius = int(input("Ingresa la temperatura en grados Celsius: "))
fahrenheit = celsius_a_fahrenheit(celsius)

print(f"{celsius}°C equivale a {fahrenheit}°F")


# EJ 10 
# Definicion de Funciones
def calcular_promedio(a, b, c):
    promedio = (a + b + c) / 3
    return promedio

# Programa Principal
print("Calcular Promedio")

a = int(input("Ingresa el primer número: "))
b = int(input("Ingresa el segundo número: "))
c = int(input("Ingresa el tercer número: "))

promedio = calcular_promedio(a, b, c)

print(f"El promedio de los tres números es: {promedio}")


print("Fin del programa, gracias por ejecutar!")