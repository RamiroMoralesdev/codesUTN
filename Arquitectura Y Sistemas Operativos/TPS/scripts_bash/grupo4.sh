#!/bin/bash


# EJ 4.1


archivo_final="union.txt"
touch $archivo_final

# recorro el archivo arch1.txt, delimitando cada lina por , separando el primer dato como equipo y el segundo como estadio
while IFS="," read -r equipo estadio
do
  # por cada valor, uso xargs para eliminar posibles espacios y lo vuelvo a asignar
  equipo=$(echo "$equipo" | xargs)

  # Recorro el archivo arch2.txt, delimitando cada lina por ; separando el primer dato como colores y el segundo como equipo_colores
  while IFS=";" read -r colores equipo_colores
  do
    equipo_colores=$(echo "$equipo_colores" | xargs) 

    # Comparo si equipo y equipo_colores es lo mismo, si se cumple la condición, armo la estructura de datos con equipo, colores y estadio y la agrego a archivo_final
    if [[ "$equipo" == "$equipo_colores" ]]; then
      echo "$equipo;$colores;$estadio" >> $archivo_final
    fi
  done < "arch2.txt"
done < "arch1.txt"


# Imprimir el contenido del archivo final
echo "Contenido de $archivo_final:"
cat $archivo_final

# EJ 4.2
# Este script permite gestionar una agenda de clubes deportivos. Esta modularizado por funciones. Cada funcion realiza una accion especifica. No comente mucho este codigo ya que es claro en cada funcion

AGENDA="agenda.txt"

# Crear archivo agenda.txt si no existe
touch "$AGENDA"

function mostrar_menu_principal() {
    echo "Total de clubes en agenda: $cantidad_clubes"
    echo "1. Ver club"  
    echo "2. Gestionar"
    echo "3. Salir"
    echo -n "Elige una opción: "
}

function mostrar_submenu_gestion() {
    echo "1. Insertar club"
    echo "2. Eliminar club"
    echo "3. Modificar"
    echo "4. Volver al menú principal"
    echo -n "Elige una opción: "
}

function buscar_club() {
    read -p "Ingrese el nombre del club: " nombre
    grep -i "^$nombre," "$AGENDA"
    if [[ $? -ne 0 ]]; then
        echo "Club no encontrado."
    fi
}

function insertar_club() {
    echo -n "Ingrese el nombre del club: "
    read nombre
    grep -iq "^$nombre," "$AGENDA"
    if [[ $? -eq 0 ]]; then
        echo "El club ya existe."
        return
    fi
    echo -n "Ingrese la provincia: "
    read provincia
    echo -n "Ingrese la localidad: "
    read localidad
    echo -n "Ingrese el código: "
    read codigo
    echo "$nombre,$provincia,$localidad,$codigo" >> "$AGENDA"
    echo "Club agregado exitosamente."
}

function eliminar_club() {
    echo -n "Ingrese el nombre del club a eliminar: "
    read nombre
    grep -iq "^$nombre," "$AGENDA"
    if [[ $? -ne 0 ]]; then
        echo "El club no existe."
        return
    fi
    grep -iv "^$nombre," "$AGENDA" > temp.txt && mv temp.txt "$AGENDA"
    echo "Club eliminado correctamente."
}

function modificar_club() {
    echo -n "Ingrese el nombre del club a modificar: "
    read nombre
    grep -iq "^$nombre," "$AGENDA"
    if [[ $? -ne 0 ]]; then
        echo "El club no existe."
        return
    fi
    eliminar_club_directo "$nombre"
    echo "Ingrese los nuevos datos:"
    echo -n "Nueva provincia: "
    read provincia
    echo -n "Nueva localidad: "
    read localidad
    echo -n "Nuevo código: "
    read codigo
    echo "$nombre,$provincia,$localidad,$codigo" >> "$AGENDA"
    echo "Club modificado correctamente."
}

function eliminar_club_directo() {
    local nombre="$1"
    grep -iv "^$nombre," "$AGENDA" > temp.txt && mv temp.txt "$AGENDA"
}

# Bucle principal
while true; do
 if [[ -f agenda.txt ]]; then
    cantidad_clubes=$(wc -l < agenda.txt)
  else
    cantidad_clubes=0
  fi
    echo
    mostrar_menu_principal
    read opcion
    case $opcion in
        1)
            buscar_club
            ;;
        2)
            while true; do
                echo
                mostrar_submenu_gestion
                read subopcion
                case $subopcion in
                    1) insertar_club ;;
                    2) eliminar_club ;;
                    3) modificar_club ;;
                    4) break ;;
                    *) echo "Opción inválida." ;;
                esac
            done
            ;;
        3)
            echo "Fin del programa..."
            break
            ;;
        *)
            echo "Opción inválida."
            ;;
    esac
done

# EJ 4.3
puntuacion="puntuacion.txt"

# verifica que el último bit del archivo si tiene dato, si es asi, agrega un salto de página
if [[ $(tail -c 1 $puntuacion | od -An -t x1 | xargs) != "0a" ]]; then
    echo >> $puntuacion
fi

pilotos=()
puntajes=()

while IFS="," read -r piloto puntos_acumulados
do
    # elimino posibles espacios
    piloto=$(echo "$piloto" | xargs)
    puntos_acumulados=$(echo "$puntos_acumulados" | xargs)

    # agrego los pilotos y los puntos_acumulados a cada lista correspondiente
    pilotos+=("$piloto")
    puntajes+=("$puntos_acumulados")

done < $puntuacion

# recorro la lista de pilotos
for i in "${!pilotos[@]}"; do
    # por cada indice, tomo el piloto, pido el putaje nuevo
    read -p "Puntaje ${pilotos[$i]}? " puntaje
    # elimino la linea del piloto en el archivo
    sed -i "/^${pilotos[$i]},/d" $puntuacion
    # ingreso neuvamente el piloto con la suma de los puntos_acumulados y el nuevo puntaje al archivo puntuacion
    echo "${pilotos[$i]},$((${puntajes[$i]} + $puntaje))" >> $puntuacion
done

# ordena de forma descendente por número y lo modifica en el archivo
sort -t',' -k2 -nr "$puntuacion" -o "$puntuacion"