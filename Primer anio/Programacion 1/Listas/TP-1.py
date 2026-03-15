multiplos_de_4 = range(0, 100, 4)
print(f"Los múltiplos de 4 son: {list(multiplos_de_4)}")


lista_de_elementos = [1, 2, 3, True, False]
print(f"El ultimo elemento en lista_de_elementos es: {lista_de_elementos[-1]}")

lista_vacia = []
print(lista_vacia)

lista_vacia.append(1)
lista_vacia.append(2)
lista_vacia.append(3)

print(f"Lista vacia ahora tiene: {lista_vacia}")

animales = ["perro", "gato", "conejo", "pez"]
print(animales)

animales[1] = "loro"
animales[3] = "oso"

print(f"Lista de animales ahora es: {animales}")

# Analizar el siguiente código
print("En el ejercicio 5 tengo una lista con 5 elementos, con el metodo remove elimino el elemento con maximo valor de esa lista. En este caso el numero 22")



saltos = range(10, 35, 5)
print(list(saltos[0:2]))




autos = ["Sedan", "Polo", "Suran", "Gol"]
autos[1] = "Ford"
autos[2] = "Fiesta"


dobles = []
dobles.append(5 * 2)
dobles.append(10 * 2)
dobles.append(15 * 2)
print(f"Lista de dobles es: {dobles}")


# Lista original
compras = [["pan", "leche"], ["arroz", "fideos", "salsa"], ["agua"]]

# a) Agregar "jugo" a la lista del tercer cliente
compras[2].append("jugo")

# b) Reemplazar "fideos" por "tallarines" en la lista del segundo cliente
compras[1][compras[1].index("fideos")] = "tallarines"

# c) Eliminar "pan" de la lista del primer cliente
compras[0].remove("pan")

print(compras)



lista_anidada = [15, True, [25.5, 57.9, 30.6], False]
print(lista_anidada)