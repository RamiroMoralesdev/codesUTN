library(readxl)
datos <- read_excel("/home/ramiromoralesdev/codesUTN/Probabilidad Y Estadistica/tabla_frecuencia.xlsx") # Tuve que poner el path completo porque sino no lo encontraba

# Verificar la estructura de los datos
str(datos)
head(datos)

# Verificar que tenemos las 3 variables esperadas
print("Variables en el dataset:")
names(datos)
print(paste("Total de observaciones:", nrow(datos)))

# Para variable categórica nominal: solo frecuencia absoluta y relativa
freq_abs_plataforma <- table(datos$Plataforma_Trabajo)
freq_rel_plataforma <- prop.table(freq_abs_plataforma)

tabla_plataforma <- data.frame(
  Plataforma = names(freq_abs_plataforma),
  Freq_Absoluta = as.vector(freq_abs_plataforma),  
  Freq_Relativa = round(as.vector(freq_rel_plataforma), 3)  
)

# Ordenar por frecuencia descendente
tabla_plataforma <- tabla_plataforma[order(tabla_plataforma$Freq_Absoluta, decreasing = TRUE), ]
rownames(tabla_plataforma) <- NULL


print("TABLA DE FRECUENCIA")
print(tabla_plataforma)

# Para variable numérica: frecuencia absoluta, relativa y acumulada
freq_abs_tickets <- table(datos$Tickets_Soporte)
freq_rel_tickets <- prop.table(freq_abs_tickets)


tabla_tickets <- data.frame(
  Tickets = names(freq_abs_tickets),
  Freq_Absoluta = as.vector(freq_abs_tickets),
  Freq_Relativa = round(as.vector(freq_rel_tickets), 3),
  Freq_Acumulada = cumsum(as.vector(freq_abs_tickets)),
  Freq_Rel_Acumulada = round(cumsum(as.vector(freq_rel_tickets)), 3)
)


print("TICKETS DE SOPORTE")
print(tabla_tickets)


print("ANÁLISIS DE TIEMPO DE CONEXIÓN")
print(summary(datos$Tiempo_Conexion))

# Regla de Sturges 
n <- length(datos$Tiempo_Conexion)
k <- ceiling(1 + 3.322 * log10(n))
print(paste("Número de clases (Regla de Sturges):", k))

# Cálculo manual de rango y amplitud 
rango <- range(datos$Tiempo_Conexion)
amplitud <- (rango[2] - rango[1]) / k
print(paste("Rango:", rango[1], "-", rango[2]))
print(paste("Amplitud de clase:", round(amplitud, 2)))

breaks <- seq(from = floor(rango[1]), 
              to = ceiling(rango[2]) + amplitud, 
              by = amplitud)


clases_tiempo <- cut(datos$Tiempo_Conexion, 
                     breaks = breaks, 
                     right = FALSE,  
                     include.lowest = TRUE)

# Construcción de la tabla de frecuencias agrupadas
freq_abs_tiempo <- table(clases_tiempo)
freq_rel_tiempo <- prop.table(freq_abs_tiempo)

tabla_tiempo <- data.frame(
  Clase = levels(clases_tiempo),  
  Freq_Absoluta = as.vector(freq_abs_tiempo),
  Freq_Relativa = round(as.vector(freq_rel_tiempo), 3),
  Freq_Acumulada = cumsum(as.vector(freq_abs_tiempo)),
  Freq_Rel_Acumulada = round(cumsum(as.vector(freq_rel_tiempo)), 3)
)


print("TABLA DE FRECUENCIAS AGRUPADAS - TIEMPO DE CONEXIÓN")
print(tabla_tiempo)


print("RESUMEN ESTADÍSTICO GENERAL")
print(paste("Total de programadores encuestados:", nrow(datos)))

print("más utilizada:")
plataforma_mas_usada <- tabla_plataforma[1, ]
print(paste(plataforma_mas_usada$Plataforma, "-", 
            round(plataforma_mas_usada$Freq_Relativa * 100, 2), "%"))

print("\nTickets de Soporte:")
print(paste("Promedio:", round(mean(datos$Tickets_Soporte), 2)))
print(paste("Mediana:", median(datos$Tickets_Soporte)))

print("\nTiempo de Conexión:")
print(paste("Promedio:", round(mean(datos$Tiempo_Conexion), 2), "horas"))
print(paste("Mediana:", median(datos$Tiempo_Conexion), "horas"))