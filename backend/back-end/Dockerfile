# Gebruik Amazon Corretto 23 als runtime image
# Use Amazon Corretto 23 as the runtime image
FROM amazoncorretto:23 AS runtime

# Set the working directory in the container
WORKDIR /app

# Copy Maven configuration and source files
COPY pom.xml ./
COPY src ./src

# Build the project using Maven
RUN ./mvnw package -DskipTests

# Expose the port on which the app runs (e.g., 8080)
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "out/*.jar"]


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
