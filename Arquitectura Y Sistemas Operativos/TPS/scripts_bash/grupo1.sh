! /bin/bash

# EJ 1
echo "Hola $LOGNAME, bienvenido a este Script"
echo "Este es tu directorio home: $HOME"
echo "El nombre de tu shell es: $SHELL"
echo "Estas posicionado en el directorio: $PWD"
echo "Estas logueado como: $USER"
echo "$SSH_TTY es tu SSH Remota"

if [[ -n $SSH_TTY ]]; then
    echo "Estas conectado a una sesion SSH"
else
    echo "No estas conectado a una sesion SSH"
fi

# EJ 2
echo "Cual es tu nombre?"
read nombre

echo "Cual es tu mensaje?"
read mensaje

write $nombre, $mensaje
echo "El mensaje ha sido enviado a $nombre" 


# EJ 3



# EJ 4

read -p "Ingresá la primera cadena: " cadena1
read -p "Ingresá la segunda cadena: " cadena2

if [[ -z "$cadena1" && -z "$cadena2" ]]; then
    echo "Ambas cadenas están vacías."
elif [[ -z "$cadena1" ]]; then
    echo "La cadena1 está vacía."
elif [[ -z "$cadena2" ]]; then
    echo "La cadena2 está vacía."
else
    echo "Ninguna cadena está vacía."
    if [[ "$cadena1" == "$cadena2" ]]; then
        echo "Las cadenas son iguales."
    else
        echo "Las cadenas son diferentes."
    fi
fi


# EJ 5 
echo "Operaciones Basicas:"
# Función para realizar las operaciones
realizar_operaciones() {
    echo "Suma: $((n1 + n2))"
    echo "Resta: $((n1 - n2))"
    echo "Multiplicación: $((n1 * n2))"
    if [ "$n2" == 0 ]; then
        echo "División: Error, no se puede dividir por cero."
    else
        echo "División: $((n1 / n2))"
    fi
}

# Verificamos cuántos parámetros se pasaron
case $# in
    0)
        echo "No ha introducido ninguno. ¿Quiere ahora? (s/n)"
        read opcion
        if [[ "$opcion" == "s" || "$opcion" == "S" ]]; then
            read -p "Ingresá el primer número: " n1
            read -p "Ingresá el segundo número: " n2
            realizar_operaciones
        else
            echo "Cancelado por el usuario."
        fi
        ;;
    1)
        echo "Ha introducido uno. ¿Quiere ahora? (s/n)"
        read opcion
        if [[ "$opcion" == "s" || "$opcion" == "S" ]]; then
            n1=$1
            read -p "Ingresá el segundo número: " n2
            realizar_operaciones
        else
            echo "Cancelado por el usuario."
        fi
        ;;
    2)
        echo "CORRECTO"
        n1=$1
        n2=$2
        realizar_operaciones
        ;;
    *)
        echo "Demasiados parámetros, tomo los dos primeros."
        n1=$1
        n2=$2
        realizar_operaciones
        ;;
esac
