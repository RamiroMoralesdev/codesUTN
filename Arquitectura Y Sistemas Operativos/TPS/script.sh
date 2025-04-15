#! /bin/bash

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

echo "Cual es tu nombre?"
read nombre

echo "Cual es tu mensaje?"
read mensaje

write $nombre, $mensaje
echo "El mensaje ha sido enviado a $nombre" 

    