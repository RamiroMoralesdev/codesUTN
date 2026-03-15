#definimos la funsion
def operaciones_bit_a_bit(a, b):
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
#pedimos al usuario que ingrese 2 numeros enteros
num1 = int(input("Ingresa el primer número entero: "))
num2 = int(input("Ingresa el segundo número entero: "))
operaciones_bit_a_bit(num1, num2) #llamamos a la funsion