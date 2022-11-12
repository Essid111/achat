FROM openjdk:11
EXPOSE 8087
ADD target/alpine.jar alpine.jar
ENTRYPOINT ["java", "-jar", "/alpine.jar" ]