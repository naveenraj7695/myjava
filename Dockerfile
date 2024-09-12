# Use a Maven base image with JDK 17
FROM maven:3.9.9.9-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and package the application
COPY src ./src
RUN mvn package

# Use the OpenJDK 17 base image for the final stage
FROM openjdk:17-jre-slim

# Set the working directory
WORKDIR /app

# Copy the packaged JAR from the build stage
COPY --from=build /app/target/ employee-1.0.0-runner.jar ./ employee-1.0.0-runner.jar

# Expose port 8080
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", employee-1.0.0-runner.jar"]

