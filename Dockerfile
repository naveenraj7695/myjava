FROM openjdk-17-slim
EXPOSE 8080
ADD target/employee-1.0.0.jar employee-1.0.0.jar
ENTRYPOINT  ["java", "-jar", "employee-1.0.0.jar"]
