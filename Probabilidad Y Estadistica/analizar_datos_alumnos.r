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

datos <- read_excel(file.choose())


# Desde aca preguntas 1 y 2 del tp
tiempo <- datos$`TIEMPO SEMANAL en HS. DEDIC. EST.`
k <- ceiling(1 + 3.322 * log10(length(tiempo)))
intervalos <- cut(tiempo, breaks = k)

tabla_tiempo      <- table(intervalos)
tabla_tiempo_rel  <- prop.table(tabla_tiempo)
tabla_tiempo_acum <- cumsum(tabla_tiempo_rel)

tabla_tiempo_final <- data.frame(
  Intervalo       = names(tabla_tiempo),
  Frecuencia      = as.vector(tabla_tiempo),
  Frec_abs_acum   = cumsum(as.vector(tabla_tiempo)),
  Relativa        = round(as.vector(tabla_tiempo_rel), 4),
  Relativa_acum   = round(as.vector(tabla_tiempo_acum), 4)
)
tabla_tiempo_final

satis <- datos$`SATISFACCIÓN CON LA CARRERA`

tabla_satis      <- table(satis)
tabla_satis_rel  <- prop.table(tabla_satis)
tabla_satis_acum <- cumsum(tabla_satis_rel)

tabla_satis_final <- data.frame(
  Categoria      = names(tabla_satis),
  Frecuencia     = as.vector(tabla_satis),
  Frec_abs_acum  = cumsum(as.vector(tabla_satis)),
  Relativa       = round(as.vector(tabla_satis_rel), 4),
  Relativa_acum  = round(as.vector(tabla_satis_acum), 4)
)


print("TABLA DE FRECUENCIAS - SATISFACCIÓN CON LA CARRERA")
print(tabla_satis_final)

print("ANÁLISIS DE TIEMPO SEMANAL DEDICADO A ESTUDIO")
print(tabla_tiempo_final)

# Desde aca preguntas 3 y 4 del tp

print("Moda, mediana, y cuartiarles de la variable Categoria")

moda <- function(x) {
  mfv(x, na.rm = TRUE) # Usando la función mfv de modeest
}

cat("Moda: ", moda(satis), "\n")
cat("Mediana: ", median(satis, na.rm = TRUE), "\n")
cat("Cuartiles: ", quantile(satis, na.rm = TRUE), "\n")


print("Tendencia central, posición y dispersión de las variables Frecuencia, Frec acum, Relativa, Relativa acum")

Frecuencia      <- tabla_satis_final$Frecuencia
Frec_abs_acum   <- tabla_satis_final$Frec_abs_acum
Relativa        <- tabla_satis_final$Relativa
Relativa_acum   <- tabla_satis_final$Relativa_acum

# Tendencia Central
media_tendencia <- mean(tiempo, na.rm = TRUE)
mediana_tendencia <- median(tiempo, na.rm = TRUE)
moda_tendencia <- mfv(tiempo, na.rm = TRUE)[1]

cat("MEDIDAS DE TENDENCIA CENTRAL:\n")
cat(sprintf("• Media: %.2f horas\n", media_tendencia))
cat(sprintf("• Mediana: %.2f horas\n", mediana_tendencia))
cat(sprintf("• Moda: %.2f horas\n", moda_tendencia))

# Posición
cuartiles_tiempo <- quantile(tiempo, probs = c(0.25, 0.5, 0.75), na.rm = TRUE)
percentil_10 <- quantile(tiempo, probs = 0.10, na.rm = TRUE)
percentil_90 <- quantile(tiempo, probs = 0.90, na.rm = TRUE)

cat("\nMEDIDAS DE POSICIÓN:\n")
cat(sprintf("• Q1 (25%%): %.2f horas\n", cuartiles_tiempo[1]))
cat(sprintf("• Q2 (50%% - Mediana): %.2f horas\n", cuartiles_tiempo[2]))
cat(sprintf("• Q3 (75%%): %.2f horas\n", cuartiles_tiempo[3]))
cat(sprintf("• Percentil 10: %.2f horas\n", percentil_10))
cat(sprintf("• Percentil 90: %.2f horas\n", percentil_90))

# Dispersión
rango_tiempo <- max(tiempo, na.rm = TRUE) - min(tiempo, na.rm = TRUE)
rango_intercuartil <- cuartiles_tiempo[3] - cuartiles_tiempo[1]
varianza_tiempo <- var(tiempo, na.rm = TRUE)
desvio_tiempo <- sd(tiempo, na.rm = TRUE)
cv_tiempo <- (desvio_tiempo / media_tendencia) * 100


# Ejercicio 4 Representar graficamente las variables 

print("Histograma")

# Crear histograma con frecuencia absoluta
hist(tiempo, 
     breaks = k,
     main = "Distribución del Tiempo Semanal Dedicado al Estudio",
     xlab = "Tiempo (horas semanales)",
     ylab = "Frecuencia Absoluta",
     col = "lightblue",
     border = "black",
     las = 1)

# Agregar líneas de referencia
abline(v = media_tendencia, col = "red", lwd = 2, lty = 2)
abline(v = mediana_tendencia, col = "blue", lwd = 2, lty = 2)

# Texto
legend("topright", 
       legend = c(paste("Media =", round(media_tendencia, 1)), 
                 paste("Mediana =", round(mediana_tendencia, 1))),
       col = c("red", "blue"), 
       lty = 2, 
       lwd = 2)

# 4.b DIAGRAMA CIRCULAR - SATISFACCIÓN

print("Diagrama circular")

# Calcular porcentajes
porcentajes <- round(tabla_satis_rel * 100, 1)
etiquetas <- paste(names(tabla_satis), "\n", porcentajes, "%", sep = "")

# Crear gráfico circular
pie(tabla_satis, 
    labels = etiquetas,
    main = "Distribución del Nivel de Satisfacción con la Carrera",
    col = rainbow(length(tabla_satis)),
    clockwise = TRUE)


print("ANALISIS DE GRAFICOS. CONCLUSIONES")

cat("El histograma muestra la distribución de las horas semanales dedicadas al estudio.")
cat("El gráfico circular muestra la distribución porcentual de los niveles de satisfacción.\n")
cat("El nivel más frecuente es:", moda_tendencia, "con", (porcentajes), "% de los estudiantes.\n")
cat("La relación entre tiempo de estudio y satisfacción podría ser explorada en análisis futuros.\n")
cat("Los datos proporcionan información valiosa para la gestión académica de la carrera.\n")
