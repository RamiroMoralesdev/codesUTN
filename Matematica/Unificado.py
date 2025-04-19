import random
import os

def limpiar_pantalla():
    os.system('cls' if os.name == 'nt' else 'clear')

def presionar_tecla_para_continuar():
    input("\nPresiona Enter para continuar...")

#definimos la funsion
def operaciones_bit_a_bit():
    limpiar_pantalla()
    a = int(input("Ingresa el primer número entero: "))
    b = int(input("Ingresa el segundo número entero: "))

    and_resultado = a & b #realizamos la operacion and
    or_resultado = a | b #realizamos la operacion or
    xor_resultado = a ^ b #realizamos la operacion xor

    #utilizamos la funcion bin() para convertir en binario
    #utlizamos [2:] para eliminar ob 
    bin_a = bin(a)[2:].zfill(8)
    bin_b = bin(b)[2:].zfill(8) 
    #utilizamos zfill() para completar con ceros hacia la izquierda
    bin_and = bin(and_resultado)[2:].zfill(8)
    bin_or = bin(or_resultado)[2:].zfill(8)
    bin_xor = bin(xor_resultado)[2:].zfill(8)

    print("Resultados:")#mostramos por pantalla la frase resultado
    print("AND:") #mstramos por pantalla la palabra and
    #mostramos por pantalla los resultados de decimal y binario de and or y xor
    print("  Decimal:", and_resultado) 
    print("  Binario:", bin_and)
    print("OR:")
    print("  Decimal:", or_resultado)
    print("  Binario:", bin_or)  
    print("XOR:")
    print("  Decimal:", xor_resultado)
    print("  Binario:", bin_xor)

    presionar_tecla_para_continuar()

def conversion():
    def conversion_decimal(binario):
        # Esta función convierte un número binario a decimal.
        decimal = 0
        potencia = 0
        
        for digito in binario[::-1]: # Recorre el número binario de derecha a izquierda.
            if digito == '1': # Si el dígito es 1, suma la potencia de 2 correspondiente.
                decimal += 2 ** potencia
            potencia += 1 # Incrementa la potencia en cada iteración.
        
        return decimal # Devuelve el número decimal.

    # Este programa convierte un número decimal a binario.
    def conversion_binario(numero):
        # Esta función convierte un número decimal a binario.
        if numero < 0: 
            raise ValueError("El número debe ser positivo.") # Si el número es negativo, lanza un error.
        
        binario = ""
        
        while numero > 0: # Si el número es cero, devuelve "0".
            residuo = numero % 2 # Calcula el residuo y lo añade al principio de la cadena binaria.
            binario = str(residuo) + binario # Añade el residuo al principio de la cadena binaria.
            numero //= 2 # Divide el número entre 2 para continuar con la conversión.
        return binario if binario else "0" # Devuelve "0" si la cadena binaria está vacía.

    limpiar_pantalla()
    numero_binario = input("Ingrese un número binario: ")
    numero_decimal = int(input("\nIngrese un número decimal: "))
    
    binario_a_decimal = conversion_decimal(numero_binario)
    decimal_a_binario = conversion_binario(numero_decimal)

    print(f"\nEl número binario {numero_binario} en decimal es: {binario_a_decimal}")
    print(f"\nEl número {numero_decimal} en binario es: {decimal_a_binario}")
    presionar_tecla_para_continuar()

def tablas_de_verdad():
    # leer_entero_validado, recibe 1 parametro:
    # un mensaje
    # comprueba que el usuario haya ingresado solamente números
    def validar_ingreso_numero(mensaje):
        while True:
            n = input(f"{mensaje}: ")
            try:
                numero = int(n)
                break
            except ValueError:
                print("Eso no es un número válido. Intente nuevamente.")

        return numero

    # leer_entero_validado, recibe 3 parametros:
    # un mensaje
    # un valor minimo   -   "-Inf" por default
    # un valor máximo   -   "Inf" por default
    # comprueba que el usuario ingrese un número entre los valores minimos y maximos
    def leer_entero_validado(mensaje, min = float("-Inf"), max = float("Inf")):
        numero = validar_ingreso_numero(mensaje)

        while numero < min or numero > max:
            print("Opción incorrecta. Ingrese un valor válido")
            numero = validar_ingreso_numero(mensaje)

        return numero

    def tabla_verdad(operacion):
        # Impresión del principio de la tabla

        if operacion == 3:
            resultado_titulo = f"{opciones[operacion]} A"
            print(f"\nTabla de Verdad para: {resultado_titulo}\n")
            print(f" A | {resultado_titulo}")
            print(f"---|{'-' * len(resultado_titulo)  + '--'}")
        else:
            resultado_titulo = f"A {opciones[operacion]} B"
            print(f"\nTabla de Verdad para: {resultado_titulo}\n")
            print(f" A | B | {resultado_titulo}")
            print(f"---|---|{'-' * len(resultado_titulo)  + '--'}")

        for A in [0, 1]:
            if operacion == 3:
                print(f" {A} | {not(A):^{len(resultado_titulo)}}")
            else:
                for B in [0, 1]:
                    if operacion == 1:
                        resultado = A and B
                    elif operacion == 2:
                        resultado = A or B
                    elif operacion == 4:
                        resultado = A ^ B
                    elif operacion == 5:
                        resultado = int(not (A and B))
                    elif operacion == 6:
                        resultado = int(not (A or B))
                    elif operacion == 7:
                        if A and not B:
                            resultado = 1
                        else:
                            resultado = 0
                    elif operacion == 8:
                        if A == B:
                            resultado = 1
                        else:
                            resultado = 0
                    print(f" {A} | {B} | {str(resultado):^{len(resultado_titulo)}}")

    def imprimir_menu(lista_menu, tiene_salir = False):
        print("\nOperaciones disponibles:")
        for op in lista_menu:
            print(f"{op} - {lista_menu[op]}")

        if tiene_salir:
            print("---------")
            print("0 - Salir\n")

    # Objeto de opciones
    opciones = {
        1: "AND",
        2: "OR",
        3: "NOT",
        4: "XOR",
        5: "NAND",
        6: "NOR",
        7: "IMPLICACION",
        8: "BICONDICIONAL"
    }

    opciones_continuar = {
        1: "SI",
        2: "NO",
    }

    def tablas():
        
        despedida = "¡Hasta luego!"
        # Menú en bucle
        
        while True:
            # Imprime de forma dinamica el menu de opciones para las tablas
            imprimir_menu(opciones, True)

            eleccion = leer_entero_validado("Selecciona una operación (0-7): ", 0, 8)
            if eleccion == 0:
                print(despedida)
                break

            tabla_verdad(eleccion)

            # Imprime de forma dinamica el menu de opciones para volver a ver
            imprimir_menu(opciones_continuar)
            ver_otra = leer_entero_validado("Desea ver otra tabla?: ", 1, 2)
            if ver_otra == 2:
                print(despedida)
                break
    limpiar_pantalla()
    tablas()
    presionar_tecla_para_continuar()

def adivina_binario():
    def decimal_a_binario(num):
        return bin(num)[2:]

    # Función para convertir un número decimal a binario, Eligiendo un numero aleatorio para el juego
    def jugar_binario_a_decimal():
        numero = random.randint(1, 255)
        binario = decimal_a_binario(numero)
        print(f"\n¿Qué número decimal representa este binario?: {binario}")
        respuesta = int(input("Tu respuesta: "))

        if int(respuesta) == numero:
            print("¡Correcto!\n")
        else:
            print(f"Incorrecto. La respuesta correcta era {numero}\n")

    # Función para convertir un número binario a decimal, Eligiendo un numero aleatorio para el juego
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
    limpiar_pantalla()
    juego()
    presionar_tecla_para_continuar()

# Función principal que muestra el menú
def main():
    while True:
        # Limpiar la pantalla antes de mostrar el menú
        limpiar_pantalla()

        # Mostrar el menú
        print("Menú Principal")
        print("1. Suma de bit a bit")
        print("2. Conversión de números")
        print("3. Tablas de verdad")
        print("4. Adivinanza de decimales y binarios")
        print("5. Salir")
        
        # Pedir al usuario que elija una opción
        opcion = input("Elige una opción (1-5): ")

        # Ejecutar la función correspondiente según la opción elegida
        if opcion == "1":
            operaciones_bit_a_bit()
        elif opcion == "2":
            conversion()
        elif opcion == "3":
            tablas_de_verdad()
        elif opcion == "4":
            adivina_binario()
        elif opcion == "5":
            print("Saliendo del programa...")
            break
        else:
            print("Opción no válida. Por favor, elige una opción válida.")
            

# Llamar a la función main para iniciar el programa
if __name__ == "__main__":
    main()
