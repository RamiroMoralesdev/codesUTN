library(readxl)

datos <- read_excel("/home/ramiromoralesdev/codesUTN/Probabilidad Y Estadistica/tabla_alumnos_estadisticas.xlsx")

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