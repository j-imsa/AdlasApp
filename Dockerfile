FROM openjdk:21-jdk-slim

WORKDIR /app
COPY target/AdlasApp-0.0.1.jar app.jar

EXPOSE 8088

ENTRYPOINT ["java", "-jar", "app.jar"]

