FROM maven:3.8.7-eclipse-temurin-19 AS builder
WORKDIR /app
COPY pom.xml .
COPY src/ src/
RUN mvn -f pom.xml clean package

FROM openjdk:19
COPY --from=builder /app/target/HiraganaAndKatakanaTestingApp.jar .
EXPOSE 8080
CMD ["java", "-jar", "HiraganaAndKatakanaTestingApp.jar"]
