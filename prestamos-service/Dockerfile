# ---- build ----
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
# Copia desde el root del repo
COPY prestamos-service/pom.xml ./prestamos-service/pom.xml
RUN mvn -q -f prestamos-service/pom.xml -DskipTests dependency:go-offline
COPY prestamos-service/src ./prestamos-service/src
RUN mvn -q -f prestamos-service/pom.xml -DskipTests clean package

# ---- run ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/prestamos-service/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
