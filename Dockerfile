FROM openjdk:11-jdk-slim as builder

COPY . /app
WORKDIR /app
RUN ./gradlew clean test bootJar --info --stacktrace --no-daemon

FROM openjdk:11-jdk-slim

COPY --from=builder /app/build/libs/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-server", "-jar", "/app/app.jar"]
