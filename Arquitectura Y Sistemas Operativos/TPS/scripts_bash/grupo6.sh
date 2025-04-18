#!/bin/bash

clear

if ! command -v finger &>/dev/null; then
    echo "'finger' no está instalado. Instalalo con: sudo apt install finger"
    return
fi

# función que verifica si el usuario existe
function existe_usuario(){
    local usuario=$1

    # si da 0 no existe
    if ! id "$usuario" &>/dev/null; then
        return 0  
    else
    # si da 1, si existe
        return 1  
    fi
}

# función que imprime si el usuario existe
function Informacion_usuario(){
    read -p "Ingrese el nombre del usuario: " usuario

    # llamada la función, en caso de no existir, muestre mensaje
    if existe_usuario "$usuario"; then
        echo "El usuario no existe"
    else
        # si el usuario existe, usa finger para mostrar la info del mismo
        echo "Usuario encontrado"
        finger "$usuario"
    fi
}


# función para validar las opciones, recibe como parametros la opción elegida, el criterio de comparacion y las opciones para mostrar en pantalla en caso de error
function validar_opcion(){ 
    local opcion=$1
    local criterios=$2
    local opciones=$3

    while [[ ! "$opcion" =~ $criterios ]]; do
        read -p "Por favor, introduce una opción válida $opciones: " opcion
    done
    # devuelve la opción correcta
    echo "${opcion^^}"
}

# función para agregar un usuario
function agregar_usuario(){ 
    # verifica si el usuario actual pertenece al grupo sudo
    if groups "$USER" | grep -q '\bsudo\b'; then
        # pide el nombre del nuevo usuario
        read -p "Nombre del usuario: " nuevo_usuario

        # llamada a la función para verificar si el usuario existe
        if existe_usuario "$nuevo_usuario"; then
            echo "El usuario no existe." 
            # si no existe, intenta crearlo con sudo
            if sudo adduser "$nuevo_usuario"; then
                echo "Usuario $nuevo_usuario creado correctamente."
            else
                echo "Error al crear usuario."
            fi
        else
            # si el usuario ya existe, lo informa
            echo "El usuario ya existe."
        fi
    else
        # si el usuario actual no tiene permisos de administrador
        echo "No tiene permiso de administrador."  
    fi
}


# función para eliminar un usuario
function eliminar_usuario(){
    # verifica si el usuario actual pertenece al grupo sudo
    if groups "$USER" | grep -q '\bsudo\b'; then
        # pide el nombre del usuario a eliminar
        read -p "Nombre del usuario a eliminar: " nuevo_usuario

         # llamada a la función para verificar si el usuario existe
        if existe_usuario "$nuevo_usuario"; then
            echo "El usuario no existe." 
        else
            # si existe, intenta eliminarlo con sudo
            if sudo deluser "$nuevo_usuario"; then
                echo "Usuario $nuevo_usuario eliminado correctamente."
            else
                echo "Error al eliminar usuario."
            fi
        fi
    else
        # si el usuario actual no tiene permisos de administrador
        echo "No tiene permiso de administrador."
    fi
}


# función que muestra el menú de gestión de usuarios
function gestion_de_usuarios() {
    # bucle infinito para mantener el menú hasta que se elija la opción volver
    while true; do 
        echo ""
        echo "Menú de gestión de usuarios"
        echo "1. Añadir"
        echo "2. Eliminar"
        echo "3. Volver"
        read -p "Elige una opción: " opcion

        # llamada a la función para validar la opción ingresada (A, E o V)
        respuesta=$(validar_opcion $opcion "^[1-3]$" "(1,2,3)")

        # ejecuta la acción correspondiente
        case $respuesta in 
            1) agregar_usuario ;;   
            2) eliminar_usuario ;;  
            3) return ;; # sale del menú (vuelve al menú principal)
        esac
    done
}


# función de menú principal
function menu_principal(){
    echo "" 
    # imprime opciones del menú
    echo "Menú Principal"
    echo "1. Información de usuario"
    echo "2. Gestión de usuario"
    echo "3. Salir"
    read -p "Elige una opción: " opcion

    # llamada a la función para validar la opción ingresada (1, 2 o 3)
    respuesta=$(validar_opcion $opcion "^[1-3]$" "(1,2,3)")

    # ejecuta la acción correspondiente
    case $respuesta in 
        # muestra información del usuario
        1) Informacion_usuario ;;    
        # abre el menú de gestión
        2) gestion_de_usuarios ;;    
        # sale del programa
        3) exit ;;                   
    esac
}

# bucle del menú principal hasta que se elija salir (opción 3)
while true; do
    menu_principal  
done