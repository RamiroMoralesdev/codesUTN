def conversion_decimal(binario):
    # Esta función convierte un número binario a decimal.
    decimal = 0
    potencia = 0
    
    for digito in binario[::-1]: # Recorre el número binario de derecha a izquierda.
        if digito == '1': # Si el dígito es 1, suma la potencia de 2 correspondiente.
            decimal += 2 ** potencia
        potencia += 1 # Incrementa la potencia en cada iteración.
    
    return decimal # Devuelve el número decimal.

# Llama a la función
binario = "1010" # Número binario a convertir.
numero_decimal = conversion_decimal(binario) # Convierte el número binario a decimal.

print(f"El número binario {binario} en decimal es: {numero_decimal}") # Muestra el resultado.

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


numero_decimal = 10 # Número decimal a convertir.
numero_binario = conversion_binario(numero_decimal) # Convierte el número decimal a binario.

print(f"El número {numero_decimal} en binario es: {numero_binario}") # Muestra el resultado

