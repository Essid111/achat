FROM openjdk:11
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "/achat.jar" ]