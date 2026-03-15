# Ejercicio 1
precios_frutas = {'Banana': 1200, 'Ananá': 2500, 'Melón': 3000, 'Uva': 1450}

precios_frutas['Naranja'] = 1200
precios_frutas['Manzana'] = 1500
precios_frutas['Pera'] = 2300

print(precios_frutas)

# Ejercicio 2
precios_frutas['Naranja'] = 1330
precios_frutas['Manzana'] = 1700
precios_frutas['Pera'] = 2800

print(precios_frutas)

# Ejercicio 3
frutas = precios_frutas.keys()
print(frutas)

# Ejercicio 4
class Persona: 
    def __init__(self, nombre, pais, edad,):
        self.nombre = nombre
        self.pais = pais
        self.edad = edad

    def saludar(self):
        print(f"Hola, soy {self.nombre}, vivo en {self.pais} y tengo {self.edad} años.")

# Ejercicio 5
import math
class Circulo: 
    def __init__(self, radio):
        self.radio = radio

    def calcular_area(self):
        # El área de un círculo es π * radio^2
        return math.pi * (self.radio ** 2)

    def calcular_perimetro(self):
        # El perímetro  es 2 * π * radio
        return 2 * math.pi * self.radio


usuario = int(input("Ingrese el radio del círculo: "))
mi_circulo = Circulo(usuario)  # Crea un círculo con radio 5
print(f"Área del círculo: {mi_circulo.calcular_area():.2f}")
print(f"Perímetro del círculo: {mi_circulo.calcular_perimetro():.2f}")


# Ejercicio 6
def balancear_parentesis(s):
    pila = []
    # Diccionario para comparar los pares de paréntesis
    pares = {')': '(', '}': '{', ']': '['}
    
    for char in s:
        if char in pares.values():  # Si es un paréntesis de apertura
            pila.append(char)
        elif char in pares.keys():  # Si es un paréntesis de cierre
            if pila and pila[-1] == pares[char]:  # Verifica el último elemento de la pila
                pila.pop()
            else:
                return False  
    return not pila  # Si la pila está vacía, los paréntesis están balanceados

# Ejecucion
print(balancear_parentesis("({[]})"))  # True
print(balancear_parentesis("({[})"))   # False


# Ejercicio 7
from collections import deque

class Banco:
    def __init__(self):
        self.cola = deque()

    def agregar_cliente(self, cliente):
        self.cola.append(cliente)
        print(f"Cliente {cliente} agregado a la cola.")

    def atender_cliente(self):
        if self.cola:
            cliente_atendido = self.cola.popleft()
            print(f"Cliente {cliente_atendido} atendido.")
        else:
            print("No hay clientes en la cola.")

    def siguiente_cliente(self):
        if self.cola:
            print(f"Siguiente cliente: {self.cola[0]}")
        else:
            print("No hay clientes en la cola.")

# Ejecucion
banco = Banco()
banco.agregar_cliente("Juan")
banco.agregar_cliente("Maria")
banco.siguiente_cliente()  # Siguiente cliente: Juan
banco.atender_cliente()  # Cliente Juan atendido.
banco.atender_cliente()  # Cliente Maria atendido.
banco.siguiente_cliente()  # No hay clientes en la cola.


# Ejercicio 8

class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.siguiente = None

class ListaEnlazada:
    def __init__(self):
        self.cabeza = None

    def insertar_inicio(self, valor):
        nuevo_nodo = Nodo(valor)
        nuevo_nodo.siguiente = self.cabeza
        self.cabeza = nuevo_nodo

    def recorrer(self):
        actual = self.cabeza
        while actual:
            print(actual.valor, end=" -> ")
            actual = actual.siguiente
        print("None")

# Ejecucion
lista = ListaEnlazada()
lista.insertar_inicio(10)
lista.insertar_inicio(20)
lista.insertar_inicio(30)
lista.recorrer()  # 30 -> 20 -> 10 -> None


# Ejercicio 9
class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.siguiente = None

class ListaEnlazada:
    def __init__(self):
        self.cabeza = None

    def insertar_inicio(self, valor):
        nuevo_nodo = Nodo(valor)
        nuevo_nodo.siguiente = self.cabeza
        self.cabeza = nuevo_nodo

    def recorrer(self):
        actual = self.cabeza
        while actual:
            print(actual.valor, end=" -> ")
            actual = actual.siguiente
        print("None")

    def invertir(self):
        prev = None
        actual = self.cabeza
        while actual:
            siguiente = actual.siguiente
            actual.siguiente = prev
            prev = actual
            actual = siguiente
        self.cabeza = prev

# Ejecucion
lista = ListaEnlazada()
lista.insertar_inicio(10)
lista.insertar_inicio(20)
lista.insertar_inicio(30)
print("Lista original:")
lista.recorrer()  # 30 -> 20 -> 10 -> None

lista.invertir()
print("Lista invertida:")
lista.recorrer()  # 10 -> 20 -> 30 -> None