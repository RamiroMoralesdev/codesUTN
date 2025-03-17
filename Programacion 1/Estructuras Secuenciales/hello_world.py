# EJ 1
print('Hello World')

# EJ 2
nombre_a_imprimir = input('Cual es tu nombre? ')
print(f"Hola {nombre_a_imprimir}")


# EJ 3
nombre = input('Cual es tu nombre? ')
apellido = input('Cual es tu apellido? ')
edad = input('Cual es tu edad? ')
pais = input('Donde vives?')

print(f"Hola, Soy {nombre} {apellido}, tengo {edad} años y vivo en {pais}")

# EJ 4
pi = 3.1416
radio = input('Ingrese el radio del un circulo para calcular su area: ')

area  = pi * float(radio) ** 2

print(f"El area del circulo es: {area}")


# EJ 5
segundos = input('Ingrese la cantidad de segundos para calcular las horas equivalentes: ')

horas = int(segundos) / 3600

print(f"{segundos} segundos equivalen a {horas} horas")


# EJ 6
numero = int(input("Ingresa un número: "))
print(f"Tabla de multiplicar del {numero}:")

for i in range(1, 11):
    print(f"{numero} x {i} = {numero * i}")

    
# EJ 7
primernumero = input('Ingrese el primer numero: ')
segundonumero = input('Ingrese el segundo numero: ')

print(f"El resultado de la suma es: {primernumero + segundonumero}")
print(f"El resultado de la resta es: {primernumero - segundonumero}")
print(f"El resultado de la multiplicacion es: {primernumero * segundonumero}")
print(f"El resultado de la division es: {primernumero / segundonumero}")


# EJ 8
peso = float(input('Ingrese su peso en kg: '))
altura = float(input('Ingrese su altura en metros: '))
masaCorporal = peso / (altura ** 2)  

print(f"Su índice de masa corporal (IMC) es: {masaCorporal:.2f}") 


# EJ 9

celsius = float(input("Ingresa la temperatura en grados Celsius: "))
fahrenheit = (9/5) * celsius + 32
print(f"{celsius}°C equivale a {fahrenheit}°F")


# EJ 10 
a = float(input("Ingresa el primer número: "))
b = float(input("Ingresa el segundo número: "))
c = float(input("Ingresa el tercer número: "))
promedio = (a + b + c) / 3
print(f"El promedio de los tres números es: {promedio}")
