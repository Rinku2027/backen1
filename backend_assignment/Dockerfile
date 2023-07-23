FROM ubuntu:latest
LABEL authors="rinku"
FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/backend_assignment.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

ENTRYPOINT ["top", "-b"]