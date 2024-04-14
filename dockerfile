FROM openjdk:11-jre-slim

WORKDIR /app

CMD ["./gradlew", "clean", "bootJar"]

COPY build/libs/*.jar app.jar

EXPOSE 8080
