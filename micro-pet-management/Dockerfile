# Stage 1: Build the application
FROM eclipse-temurin:17-jdk-noble AS builder

WORKDIR /app

# Copiar archivos relevantes para aprovechar el cache de Docker
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Descargar dependencias primero para cache
RUN ./mvnw dependency:go-offline

# Copiar el resto del código fuente
COPY src ./src

# Compilar el proyecto
RUN ./mvnw clean package -DskipTests

# Stage 2: Crear imagen más liviana para ejecutar
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copiar el JAR generado desde el builder
COPY --from=builder /app/target/*.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]