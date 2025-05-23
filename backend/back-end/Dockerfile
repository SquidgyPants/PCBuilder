# Gebruik Amazon Corretto 23 als runtime image
# Use Amazon Corretto 23 as the runtime image
FROM amazoncorretto:23 AS runtime

# Set the working directory in the container
WORKDIR /app

RUN mvn install
RUN mvn wrapper:wrapper

# Copy Maven configuration and source files
COPY pom.xml ./
COPY src ./src
COPY mvnw ./

# Build the project using Maven
RUN ./mvwn clean package

# Expose the port on which the app runs (e.g., 8080)
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "target/.jar"]