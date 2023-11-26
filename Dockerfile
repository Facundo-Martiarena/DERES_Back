FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -DexcludeScope=development

COPY src ./src

RUN mvn package -DskipTests

FROM openjdk:17.0.1-jdk-slim
WORKDIR /app

COPY --from=build /app/target/deres-0.0.1-SNAPSHOT.jar app.jar

RUN apt-get update && apt-get install -y rabbitmq-server


ENTRYPOINT ["java", "-jar", "app.jar"]
