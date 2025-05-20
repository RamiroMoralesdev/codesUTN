# Actividad 1: calcule el factorial de un número. Luego,  el factorial de todos los números enteros entre 1 y el número que indique el usuario

def factorial(n):
    if n == 0:
        return 0
    else:
        return n * factorial(n - 1)
    
    
def main():
    num = int(input("Ingrese un número: "))
    if num < 0:
        print("El número debe ser mayor a 0")
    else:
        for i in range(1, num + 1):
            print(f"El factorial de {i} es: {factorial(i)}")

main()