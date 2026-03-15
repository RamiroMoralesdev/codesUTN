function grupo3 {
    #!/bin/bash

#EJ 3.1
# Solicitar al usuario la ruta del archivo
read -p "Ingrese la ruta del archivo: " archivo


# Verificar si el archivo existe
if [[ -e "$archivo" ]]; then
    echo "El archivo $archivo existe"

    # Determinar el tipo de archivo
    if [[ -b "$archivo" ]]; then
        echo "Es un archivo especial de bloques"
    elif [[ -c "$archivo" ]]; then
        echo "Es un archivo especial de caracteres"
    elif [[ -d "$archivo" ]]; then
        echo "Es un directorio"
    elif [[ -f "$archivo" ]]; then
        echo "Es un archivo ordinario"
    elif [[ -h "$archivo" ]]; then
        echo "Es un archivo simbólico"
    else
        echo "El tipo de archivo no es reconocido."
    fi

    # Verificar los permisos
    if [[ -r "$archivo" ]]; then
        echo "Tiene permiso de lectura"
    fi

    if [[ -w "$archivo" ]]; then
        echo "Tiene permiso de escritura"
    fi

    if [[ -x "$archivo" ]]; then
        echo "Tiene permiso de ejecución"
    fi

else
    echo "El archivo $archivo no existe"
fi

# EJ 3.2
read -p "Ingrese la extensión del archivo (sin el punto): " extension

for file in *"$extension"; do
  if [[ -f "$file" ]]; then
    echo "Nombre del archivo: $file"
    
    contenido=$(cat "$file")

    if [[ -z "$contenido" ]]; then
      echo "El archivo está vacío"
    else
      echo "Contenido del archivo:"
      echo "$contenido"
    fi

    echo "----------------------------"
  fi
done

}