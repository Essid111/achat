FROM openjdk:11
EXPOSE 8087
ADD target/achat.jar achat.jar
ENTRYPOINT ["java", "-jar", "/achat.jar" ]