# Validar si readxl está instalado, sino instalar
if (!require("readxl")) {
  install.packages("readxl")
  library(readxl)
} else {
  library(readxl)
}

# Libreria para calcular moda
if (!require("modeest")) {
  install.packages("modeest")
  library(modeest)
} else {
  library(modeest)
}


datos <- read_excel(file.choose()) # Usar file.choose() para seleccionar el archivo. Porque no me esta encontrando el archivo con path 

# Función para calcular moda
moda <- function(x) {
  mfv(x, na.rm = TRUE) # Usando la función mfv de modeest
}

vars <- c("Tickets_Soporte", "Tiempo_Conexion")

# Calcular estadísticas. Usando for para iterar y funciones reservadas. cat para imprimir en una sola línea
for (v in vars) {
  cat("\n---", v, "---\n")
  x <- datos[[v]]
  
  cat("Media: ", mean(x, na.rm = TRUE), "\n")
  cat("Mediana: ", median(x, na.rm = TRUE), "\n")
  cat("Moda: ", moda(x), "\n")
  cat("Cuartiles:\n")
  cat(quantile(x, probs = c(0.25, 0.5, 0.75), na.rm = TRUE), "\n")
  cat("Desvío estándar: ", sd(x, na.rm = TRUE), "\n")
}
