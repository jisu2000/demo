# Use the official maven/Java parent image for the build stage
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the image
WORKDIR /app

# Copy pom.xml and source code to the container
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Use OpenJDK JRE for the runtime stage
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your Spring Boot application listens on (default is 8080)
EXPOSE 8080

# Command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "/app/app.jar"]
