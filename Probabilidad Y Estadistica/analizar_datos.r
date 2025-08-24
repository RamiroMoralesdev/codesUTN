
library(readxl)
datos <- read_excel("/home/ramiromoralesdev/codesUTN/Probabilidad Y Estadistica/tabla_frecuencia.xlsx")

# Verificar la estructura de los datos
str(datos)
head(datos)

# Verificar que tenemos las 3 variables esperadas
print("Variables en el dataset:")
names(datos)
print(paste("Total de observaciones:", nrow(datos)))

# Para variable categórica nominal: solo frecuencia absoluta y relativa
freq_abs_plataforma <- table(datos$Plataforma_Trabajo)
freq_rel_plataforma <- prop.table(freq_abs_plataforma) * 100


tabla_plataforma <- data.frame(
  Plataforma = names(freq_abs_plataforma),
  Freq_Absoluta = as.numeric(freq_abs_plataforma),
  Freq_Relativa = round(as.numeric(freq_rel_plataforma), 2)
)

# Ordenar por frecuencia descendente
tabla_plataforma <- tabla_plataforma[order(tabla_plataforma$Freq_Absoluta, decreasing = TRUE), ]
rownames(tabla_plataforma) <- NULL

# Mostrar tabla
print("TABLA DE FRECUENCIA - PLATAFORMA DE TRABAJO")
print(tabla_plataforma)


# Para variable numérica: frecuencia absoluta, relativa y acumulada
freq_abs_tickets <- table(datos$Tickets_Soporte)
freq_rel_tickets <- prop.table(freq_abs_tickets) * 100

# Crear data frame
tabla_tickets <- data.frame(
  Tickets = as.numeric(names(freq_abs_tickets)),
  Freq_Absoluta = as.numeric(freq_abs_tickets),
  Freq_Relativa = round(as.numeric(freq_rel_tickets), 2)
)

# Calcular frecuencias acumuladas
tabla_tickets$Freq_Acumulada <- cumsum(tabla_tickets$Freq_Absoluta)
tabla_tickets$Freq_Rel_Acumulada <- round(cumsum(tabla_tickets$Freq_Relativa), 2)

# Ordenar por valor de tickets
tabla_tickets <- tabla_tickets[order(tabla_tickets$Tickets), ]
rownames(tabla_tickets) <- NULL

# Mostrar tabla
print("TICKETS DE SOPORTE")
print(tabla_tickets)



# Primero, explorar los datos para determinar las clases
print("TIEMPO DE CONEXION")
print(summary(datos$Tiempo_Conexion))

# Calcular número de clases usando la regla de Sturges
n_clases <- ceiling(log2(nrow(datos)) + 1)
print(paste("Número de clases sugerido (Sturges):", n_clases))

# Crear clases usando cut()
clases_tiempo <- cut(datos$Tiempo_Conexion, 
                     breaks = n_clases, 
                     include.lowest = TRUE,
                     dig.lab = 2)

# Crear tabla de frecuencia para las clases
freq_abs_tiempo <- table(clases_tiempo)
freq_rel_tiempo <- prop.table(freq_abs_tiempo) * 100

tabla_tiempo <- data.frame(
  Clase = names(freq_abs_tiempo),
  Freq_Absoluta = as.numeric(freq_abs_tiempo),
  Freq_Relativa = round(as.numeric(freq_rel_tiempo), 2)
)

# Calcular frecuencias acumuladas
tabla_tiempo$Freq_Acumulada <- cumsum(tabla_tiempo$Freq_Absoluta)
tabla_tiempo$Freq_Rel_Acumulada <- round(cumsum(tabla_tiempo$Freq_Relativa), 2)

# Mostrar tabla
print("TIEMPO DE CONEXIÓN (Agrupado en clases)")

print(tabla_tiempo)



print("RESUMEN ESTADÍSTICO GENERAL")

# Total de observaciones
print(paste("Total de programadores encuestados:", nrow(datos)))

# Resumen por variable
print("\nPlataforma de Trabajo más utilizada:")
plataforma_mas_usada <- tabla_plataforma[1, ]
print(paste(plataforma_mas_usada$Plataforma, "-", 
            plataforma_mas_usada$Freq_Relativa, "%"))

print("\nTickets de Soporte:")
print(paste("Promedio:", round(mean(datos$Tickets_Soporte), 2)))
print(paste("Mediana:", median(datos$Tickets_Soporte)))
print(paste("Mínimo:", min(datos$Tickets_Soporte)))
print(paste("Máximo:", max(datos$Tickets_Soporte)))

print("\nTiempo de Conexión:")
print(paste("Promedio:", round(mean(datos$Tiempo_Conexion), 2), "horas"))
print(paste("Mediana:", median(datos$Tiempo_Conexion), "horas"))
print(paste("Mínimo:", min(datos$Tiempo_Conexion), "horas"))
print(paste("Máximo:", max(datos$Tiempo_Conexion), "horas"))
