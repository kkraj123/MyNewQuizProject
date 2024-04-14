FROM openjdk:11-jre-slim

WORKDIR /app

COPY ./path/to/your/application.jar /app/application.jar

CMD ["java", "-jar", "application.jar"]