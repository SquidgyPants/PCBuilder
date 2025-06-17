FROM maven:3.9.4-eclipse-temurin-21 AS build

# Set the working directory in the container
WORKDIR /app

# Copy Maven configuration and source files
COPY pom.xml ./
COPY src ./src

# Build the project using Maven
RUN mvn clean package -DskipTests

# Use a smaller base image for the runtime
FROM openjdk:21 AS runtime

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /target/*.jar app.jar

# Expose the port on which the app runs (e.g., 8080)
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "target/*.jar"]