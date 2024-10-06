FROM openjdk:17-jdk-slim

COPY /target/candidate-service-0.0.1-SNAPSHOT.jar /app/candidate-service-0.0.1-SNAPSHOT.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "candidate-service-0.0.1-SNAPSHOT.jar"]