# Gebruik Amazon Corretto 23 als runtime image
FROM amazoncorretto:23 AS runtime

# Stel de werkdirectory in de container in
WORKDIR /app

# Kopieer je Spring Boot JAR (die je lokaal bouwt met Maven of Gradle)
COPY target/*.jar BackEndApplication.jar

# Expose de poort waarop je app draait (bijv. 8080)
EXPOSE 8080

# Start de Spring Boot applicatie
ENTRYPOINT ["java", "-jar", "app.jar"]


#FROM amazoncorretto:23
#LABEL authors="Squidgy"
#
## Gebruik een JDK base image om de app te bouwen
#FROM amazoncorretto:23 AS build
#
## Stel de working directory in
#WORKDIR /app
#
## Kopieer je Maven of Gradle bestanden
#COPY pom.xml ./
#COPY src ./src
#
## Bouw het project (zorg dat Maven geïnstalleerd is in je project)
#RUN ./mvnw package -DskipTests
#
## Gebruik een lichtere image voor de uiteindelijke container
#FROM openjdk:17-jdk-slim
#
## Stel de werkdirectory in
#WORKDIR /app
#
## Kopieer het JAR-bestand vanuit de build container
#COPY --from=build /app/target/*.jar app.jar
#
## Start de app
#ENTRYPOINT ["java", "-jar", "app.jar"]
