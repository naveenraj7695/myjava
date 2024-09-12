# Use Maven to build the application
FROM maven:3.8.6-jdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and install dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and package the application
COPY src ./src
RUN mvn package

# Use an OpenJDK image to run the application
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/your-app.jar ./your-app.jar

# Define the command to run your app
ENTRYPOINT ["java", "-jar", "your-app.jar"]
