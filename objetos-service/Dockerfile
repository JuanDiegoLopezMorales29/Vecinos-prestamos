# ---- build ----
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
# Copia desde el root del repo
COPY objetos-service/pom.xml ./objetos-service/pom.xml
RUN mvn -q -f objetos-service/pom.xml -DskipTests dependency:go-offline
COPY objetos-service/src ./objetos-service/src
RUN mvn -q -f objetos-service/pom.xml -DskipTests clean package

# ---- run ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/objetos-service/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
