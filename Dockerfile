# Use a base image with Java 22 and Maven
FROM maven:3.9.6-eclipse-temurin-22-jammy

# Set the working directory in the Docker image
WORKDIR /app

# Copy the project files to the working directory
COPY . .

# Expose the port that the Spring Boot application runs on
EXPOSE 8080

# Run the Spring Boot application using Maven
CMD ["mvn", "spring-boot:run"]
