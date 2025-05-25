a = input("Ingrese un DNI: ")
b = input("Ingrese un segundo DNI: ")
print(type(a))
print(type(b))
def conjuntos(a, b):
    a = list(a)
    b = list(b)
    print("Conjunto A:", a)
    print("Conjunto B:", b)

    union = a + b 
    # Convierto en set para eliminar elementos repetidos
    interseccion = list(set(a) & set(b))
    diferencia = list(set(a) - set(b))
    diferencia_simetrica = list(set(a) ^ set(b)) # ^ = OR


    print(f"Union:", union )
    print(f"Interseccion:", interseccion)
    print(f"Diferencia:", diferencia)  
    print(f"Diferencia Simetrica:", diferencia_simetrica)

conjuntos(a, b)

# Conteo de frecuencia de cada digito en cada conjunto utilizando estructuras repetivas. La frecuencia es la cantidad de veces que aparece un digito en el conjunto.

for i in range(10):
    frecuencia_a = a.count(str(i))
    frecuencia_b = b.count(str(i))
    print(f"Frecuencia del dígito {i} en el conjunto A: {frecuencia_a}")
    print(f"Frecuencia del dígito {i} en el conjunto B: {frecuencia_b}")


# Suma total de todos los dígitos en cada conjunto

def suma_recursiva_digitos(n):
    if n == 0:
        return 0
    else:
        return n % 10 + suma_recursiva_digitos(n // 10) # n % 10 = retorna el ultimo dígito, n // 10 = saca el resto

n = int(a)
print(f"La suma de los dígitos de {n} es: {suma_recursiva_digitos(n)}")

n = int(b)
print(f"La suma de los dígitos de {n} es: {suma_recursiva_digitos(n)}")



# Operaciones con anos de nacimiento

a = int(input("Ingrese un año de nacimiento: "))
b = int(input("Ingrese un año de nacimiento: "))
def calcular_par_impar(a,b):

    # Contar cuántos nacieron en años pares e impares utilizando estructuras repetitivas.
    
    while a % 2 == 0 & b % 2 == 0: # Si a es par o b es par
        print(f"Los años {a} y {b} son pares")
        break
    else: 
        print(f"Los años {a} y {b} son impares")
    
    
    if a & b > 2000:
        print("Grupo Z")
     
    def es_bisiesto(a):
        if a % 4 == 0 and (a % 100 != 0 or a % 400 == 0):
            return True
        else:
            return False
        
    if es_bisiesto(a) == True or es_bisiesto(b) == True:
        print("Tenemos un año especial")
    else: print("Ninguno de los años es bisiesto")

calcular_par_impar(a,b)