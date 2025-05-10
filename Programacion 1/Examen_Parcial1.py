# i = 1
# while i <= 2:
#     print("Iteracion exterior:", i, end=" ")
#     j = 1
#     bandera = True
#     while bandera:
#         print("Iteracion interior:", j, end=" ")
#         j += 1
#         if j != 2:
#             bandera = False
#         i = i + 1



# for t in range (0,3):
#     for n in range (1,4):
#       print(t*n, end=" ")


# lista = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
# lista[0] = 1
# lista[1] = 1
# lista[2] = 1
# lista[3] = 2
# lista[4] = 1

# n = 5
# r = 0

# if n == 0:
#     r = 0
# else:
#     r = lista[n-1]
#     for i in range(n-1, 0, -1):
#         r += lista[i-1]

# print(r)



f = "HolaMundoCruel"
r = f
l = len(f)  # 14

for i in range(0, l + 1, 5):  # i tomará el valor 0 y luego 11
    r = f[i:l]  # r = f[11:14] = "uel"
    print(r)


for n in range(1, 11):
    bandera = False
    d = 0

    for c in range(1, n + 1):
        if n % c == 0:
            d += 1

    if d <= 2:
        bandera = True
    else:
        bandera = False

    if bandera:
        print(n, end=" ")




# N = 5
# A = [0] * N
# B = [0] * N

# for i in range(N):
#     A[i] = i + i + i  # This equals 3i

# for i in range(N):
#     B[i] = i * 2

# contador = 0
# for i in range(N):
#     if A[0] == A[i] and A[0] == B[i]:  # First blank is == and second is 
#         contador += 1
#         N = N - contador

# resultado = str(contador)

# if A[0] == 1:  # This blank is ==
#     resultado = "VERDADERO"
# elif A[0] == 2:  # This blank is ==
#     resultado = "2"
# elif A[0] == 3:  # This blank is ==
#     # This part is incomplete in the original code
#     pass

# print(resultado)



# num1 = 3
# num2 = 7
# num3 = 4

# if num2 % 2 == 0:  # Falso (7%2 != 0), entramos al else
#     x = num2 * 2
# else:
#     x = 3 * num2    # x = 3*7 = 21

# if x % 2 == 0:      # Falso (21%2 != 0), entramos al else
#     t = x + num3
# else:
#     t = x - num3    # t = 21-4 = 17

# if t > 10:          # Verdadero (17 > 10)
#     resultado_final = t * num1  # resultado_final = 17*3 = 51
# else:
#     resultado_final = t + num1

# print(f"Resultado final: {resultado_final}")



# # Inicialización de las variables
# contador = 1
# suma = 0
# bandera = True

# num1 = int(input("Ingrese un valor N°1:"))  # Suponemos que ingresa 3

# while bandera:
#     num2 = int(input("Ingrese un valor N°2:"))  # Suponemos que ingresa 5
#     suma = suma + num2
#     contador = contador + 1
    
#     while contador <= num1:
#         print(suma, end=",")
#         bandera = False
#         if contador == num1:
#             bandera = True
#         break


# # Inicialización de las variables
# num1 = 3
# vector = [4, 6, 1]

# mayor = vector[0]  # mayor inicia con el primer elemento (4)

# for i in range(1,num1):
#     if vector[i] > mayor:
#         mayor = vector[i]  # Actualiza mayor si encuentra un valor mayor

# print(mayor)  # Imprime el valor mayor (6)


# # Entrada de datos
# dia = int(input("Introduce el valor N°1: ")) # Día
# mes = int(input("Introduce el valor N°2: ")) # Mes
# anio = int(input("Introduce el valor N°3: ")) # Año

# if mes in [1, 3, 5, 7, 8, 10, 12]:
#     dd = 31
# elif mes in [4, 6, 9, 11]:
#     dd = 30
# elif mes == 2:
#     if (anio % 4 == 0 and anio % 100 != 0) or (anio % 400 == 0):
#         dd = 29
#     else:
#         dd = 28
# else:
#     print("A")
#     dd = -1

# if dd == -1:
#     if dia < 1 or dia > dd: # Aquí 'dd' es -1, por lo que 'dia > dd' siempre será True si dia >= 1
#         print("B")
#     elif mes < 1 or mes > 12:
#         print("C")
#     else:
#         print("D")