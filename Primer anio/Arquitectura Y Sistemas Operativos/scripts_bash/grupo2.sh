function grupo2 {
    #!bin/bash
# EJ 2.1

read -p "Ingresá una nota numérica del 0 al 10: " nota

# Validar que sea un número entero positivo (entre 0 y 10)
if [[ ! "$nota" =~ ^[0-9]+$ || "$nota" -gt 10 ]]; then
    echo "Por favor, introduce un número válido."
    exit 1
fi

# Evaluar y mostrar la calificación alfabética
if [ "$nota" -ge 9 ]; then
    echo "Sobresaliente"
elif [ "$nota" -ge 7 ]; then
    echo "Notable"
elif [ "$nota" -ge 6 ]; then
    echo "Bien"
elif [ "$nota" -ge 5 ]; then
    echo "Suficiente"
else
    echo "Insuficiente"
fi


# EJ 2.2

while true; do
    echo "1. Calcular el área de un rectángulo"
    echo "2. Calcular el perímetro de un rectángulo"
    echo "3. Salir"
   
    read -p "Elegí una opción (1/2/3): " opcion

    case $opcion in
        1)
            read -p "Ingresá la base: " base
            read -p "Ingresá la altura: " altura
            if [[ "$base" =~ ^[0-9]+$ && "$altura" =~ ^[0-9]+$ ]]; then
                area=$((base * altura))
                echo "El área del rectángulo es: $area"
            else
                echo "Datos inválidos. Ingresá solo números enteros positivos."
            fi
            ;;
        2)
            read -p "Ingresá la base: " base
            read -p "Ingresá la altura: " altura
            if [[ "$base" =~ ^[0-9]+$ && "$altura" =~ ^[0-9]+$ ]]; then
                perimetro=$(((base + altura) * 2))
                echo "El perímetro del rectángulo es: $perimetro"
            else
                echo "Datos inválidos. Ingresá solo números enteros positivos."
            fi
            ;;
        3)
            echo "¡Hasta luego!"
            break
            ;;
        *)
            echo "Opción inválida. Por favor, elegí 1, 2 o 3."
            ;;
    esac

    echo 
    echo "Fin del programa"
done

# EJ 2.3

archivo_temp="numeros_temp.txt"
> "$archivo_temp"  # Vaciar/crear el archivo temporal

# 1. Ingreso de números hasta 999
while true; do
    read -p "Ingresá un número (999 para salir): " numero
    if [[ "$numero" == "999" ]]; then
        break
    elif [[ "$numero" =~ ^-?[0-9]+$ ]]; then
        echo "$numero" >> "$archivo_temp"
    else
        echo "Solo se permiten números enteros."
    fi
done


read -p "¿Quieres ver los números introducidos? (s/n): " opcion

if [[ "$opcion" =~ ^[sS]$ ]]; then
    read -p "¿Orden de ingreso, ascendente o descendente? (o/a/d): " orden

    echo "Números:"
    case "$orden" in
        o|O)
            cat "$archivo_temp"
            ;;
        a|A)
            sort -n "$archivo_temp"
            ;;
        d|D)
            sort -nr "$archivo_temp"
            ;;
        *)
            echo "Opción no válida"
            ;;
    esac
fi

# 5. Eliminar archivo temporal
rm -f "$archivo_temp"

echo "Hasta la vista"


# EJ 2.4
intentos=3
respuesta_correcta=4

for ((i=1; i<=intentos; i++)); do
    read -p "¿Cuánto es 2 + 2?: " respuesta

    if [[ "$respuesta" == "$respuesta_correcta" ]]; then
        echo "CORRECTO, acertado en el intento $i"
        exit 0
    else
        restantes=$((intentos - i))
        if [[ $restantes -gt 0 ]]; then
            echo "Incorrecto. Te quedan $restantes intento(s)."
        else
            echo "Game Over"
        fi
    fi
done


# EJ 2.5

aciertos=0
preguntas=()
respuestas=()

# hacemos un while para recorrer el archivo, usando como delimitador el ;, separando el primer parametro en pregunta y el segundo en respuesta
while IFS=";" read -r pregunta respuesta
do
  # agrego la pregunta y respuesta, a sus listas respectivamente
  preguntas+=("$pregunta")
  respuestas+=("$respuesta")
done < "pregyresp.txt"

# hago un for por el total de los elementos de la lista de preguntas y con el mismo indice la muestro, esperando la respuesta del usuario
for i in "${!preguntas[@]}"; do
  read -p "${preguntas[$i]}? " respuesta

  # si la respuesta del usuario es igual a la respuesta con el mismo indice que la pregunta, incremento aciertos a 1
  if [[ "$respuesta" -eq "${respuestas[$i]}" ]]; then
    aciertos=$((aciertos + 1))
  fi
done

echo "Tienes $aciertos aciertos." 
}