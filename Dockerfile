# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file into the Docker image
COPY target/my-java-app.jar /app/my-java-app.jar

# Specify the command to run the JAR file
ENTRYPOINT ["java", "-jar", "my-java-app.jar"]

# Expose the port the application runs on
EXPOSE 8080
