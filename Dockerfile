FROM eclipse-temurin:21-jdk-jammy
WORKDIR /spring-app
COPY ./target/rolesecurity-0.0.1-SNAPSHOT.jar spring-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-app.jar"]