FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/achat-1.0.jar achat-1.0.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","achat-1.0.jar"]