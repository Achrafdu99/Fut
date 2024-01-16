# Étape 1: Utiliser une image de base officielle avec Maven pour construire le projet
FROM maven:3.8.4-openjdk-17 AS build
LABEL image.name="teamservice" image.tag="latest"

COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

# Étape 2: Utiliser une image Java légère pour l'exécution
FROM openjdk:17-oracle
COPY --from=build /usr/src/app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]
