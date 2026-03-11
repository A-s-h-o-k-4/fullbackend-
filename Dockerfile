FROM eclipse-temurin:21-jdk-jammy
WORKDIR /spring-app
COPY target/*.jar spring-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-app.jar"]