# Juego de Adivinanza en Binario:
# Muestren un número en binario y desafíen al usuario a adivinar su equivalente decimal, o viceversa, reforzando la conversión entre ambos sistemas.

import random

def decimal_a_binario(num):
    return bin(num)[2:]

def binario_a_decimal(binary_str):
    return int(binary_str, 2)

def jugar_binario_a_decimal():
    numero = random.randint(1, 255)
    binario = decimal_a_binario(numero)
    print(f"\n¿Qué número decimal representa este binario?: {binario}")
    respuesta = int(input("Tu respuesta: "))

    if int(respuesta) == numero:
        print("¡Correcto!\n")
    else:
        print(f"Incorrecto. La respuesta correcta era {numero}\n")

def jugar_decimal_a_binario():
    numero = random.randint(1, 255)
    print(f"\n¿Qué número binario representa este decimal?: {numero}")
    respuesta = input("Tu respuesta: ")

    if respuesta == decimal_a_binario(numero):
        print("¡Correcto!\n")
    else:
        print(f"Incorrecto. La respuesta correcta era {decimal_a_binario(numero)}\n")

def juego():
    print(" Bienvenido al Juego de Adivinanza Binaria, estas listo para jugar?")
    while True:
        print("¿Qué quieres hacer?")
        print("1. Adivinar el número decimal a partir de binario")
        print("2. Adivinar el número binario a partir de decimal")
        print("3. Salir")

        opcion = input("Elige una opción: ")
        if opcion == "1":
            jugar_binario_a_decimal()
        elif opcion == "2":
            jugar_decimal_a_binario()
        elif opcion == "3":
            print("¡Gracias por jugar! ")
            break
        else:
            print("Opción inválida, intentá de nuevo.\n")

# Ejecutar el juego
if __name__ == "__main__":
    juego()
