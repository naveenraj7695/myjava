# Use an official Java runtime as a parent image with Java 17
FROM openjdk:17-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the local JAR file to the container
COPY target/employee-1.0.0-runner.jar /app/employee-1.0.0-runner.jar

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "myjava.jar"]

