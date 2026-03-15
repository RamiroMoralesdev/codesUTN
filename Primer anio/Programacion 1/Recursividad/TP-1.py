# Actividad 1: calcule el factorial de un número. Luego,  el factorial de todos los números enteros entre 1 y el número que indique el usuario
def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1)
    
    
def main():
    print("Actividad 1: Factorial de un número")

    num = int(input("Ingrese un número: "))
    if num <= 0:
        print("El número debe ser mayor a 0")
    else:
        for i in range(1, num + 1):
            print(f"El factorial de {i} es: {factorial(i)}")

main()



# Actividad 2: Funcion recursiva que calcule el valor de Fibonacci en la posicion indicada. Muestra la serie de Fibonacci hasta la posicion indicada por el usuario.

def fibonacci(pos):
    if pos == 0:
        return 0
    elif pos == 1:
        return 1
    else:
        return fibonacci(pos - 1) + fibonacci(pos - 2)
    
posicion = int(input("Ingrese la posición de Fibonacci: "))

for i in range(posicion + 1):
    print(f"El valor de Fibonacci en la posición {i} es: {fibonacci(i)}")

fibonacci(posicion)


# Actividad 3: Funcion recursiva que calcule la potencia de un numero base elevado a un exponente. Prueba esta funcion en un algoritmo general 
print("Actividad 3: Potencia de un número")
numero = int(input("Ingrese un número: "))
exponente = int(input("Ingrese el exponente: "))

def potencia(base, exp):
    if exp == 0:
        return 1
    else:
        return base * potencia(base, exp - 1)

print(f"{numero} elevado a {exponente} = {potencia(numero, exponente)}")


# Actividad 4: Funcion recursiva que reciba numero entero en base 10 y retorne numero en base 2.

def convertir_a_binario(decimal):
    if decimal == 0:
        return ''
    else:
        return convertir_a_binario(decimal // 2) + str(decimal % 2)

decimal = int(input("Ingrese un número en base 10: "))

if decimal <= 0:
    print("Ingrese un número mayor a 0")
else:
    binario = convertir_a_binario(decimal)
    print(f"El número {decimal} en base 2 es: {binario}")


# Actividad 5: Funcion recursiva que reciba un string sin espacios ni tildes y devuelva si es un palíndromo o no. True o False. Un palindromo es una palabra o frase que se lee igual de izquierda a derecha que de derecha a izquierda.
# No puedo usar slincling [::-1] o reversed()
def es_palindromo(palabra):
    if len(palabra) <= 1:
        return True
    if palabra[0] != palabra[-1]:
        return False
    return es_palindromo(palabra[1:-1])  # sigue con la palabra sin la posicion 0 y -1

palabra = input(str("Ingrese una palabra para verificar si es un palíndromo: "))


resultado = es_palindromo(palabra)

print(f"{palabra} es palíndromo? {resultado}")



# Actividad 6: Suma recursiva a partir de un numero entero positivo y devuelve la suma de TODOS sus dígitos.

def suma_digitos(n):
    if n == 0:
        return 0
    else:
        return n % 10 + suma_digitos(n // 10) # n % 10 = retorna el ultimo dígito, n // 10 = saca el resto

n = int(input("Ingrese un número entero: "))
print(f"La suma de los dígitos de {n} es: {suma_digitos(n)}")


# Actividad 7: Funcion recursiva que reciba un numero de bloques y delvuelva el total de bloques que se necesitan para construir una pirámide de bloques. (Llegar a 0)

def contar_bloques(n):
    if n == 0:
        return 0
    else:
        return n + contar_bloques(n - 1)

n = int(input("Ingrese el número de bloques en el nivel mas bajo: ")) 
print(f"Se necesitan {contar_bloques(n)} bloques para construir toda la pirámide.")



# Actividad 8: Funcion recursiva que reciba un numero entero positivo y un digito entre 0 y 9. Devuelva la cantidad de veces que aparece el digito en el numero.

def contar_digito(numero, digito):
    if numero == 0:
        return 0
    else:
        ultimo_digito = numero % 10
        digito_veces = 1 if ultimo_digito == digito else 0
        return digito_veces + contar_digito(numero // 10, digito) # numero // 10 = saca el último dígito
    
print("Actividad 8: Contar dígitos en un número")
numero = int(input("Ingrese un número entero positivo: "))
digito = int(input("Ingrese un dígito entre 0 y 9: "))

print(f"El dígito {digito} aparece {contar_digito(numero, digito)} veces en el número {numero}.")