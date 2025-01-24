# Se compila el proyecto
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY . ./payments-api/pom.xml payments-api/
COPY . ./payments-core/pom.xml payments-core/
COPY . ./payments-data/pom.xml payments-data/
COPY . ./payments-services/pom.xml payments-services/
COPY . ./payments-api/src payments-api/src
COPY . ./payments-core/src payments-core/src
COPY . ./payments-data/src payments-data/src
COPY . ./payments-services/src payments-services/src

RUN mvn clean package -Dskiptest

# Primer servicio
FROM eclipse-temurin:17-jdk-alpine AS api
WORKDIR /app
COPY --from=build /app/payments-api/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]


# Segundo servicio
FROM eclipse-temurin:17-jdk-alpine AS payment-core
WORKDIR /app
COPY --from=build /app/payments-core/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]