#Start with a base image containing Java runtime
FROM eclipse-temurin:21-jdk

#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="nadia"

# Add the application's jar to the image
COPY target/entreprise-microservice-0.0.1-SNAPSHOT.jar entreprise-microservice-0.0.1-SNAPSHOT.jar

EXPOSE 8080

# execute the application
ENTRYPOINT ["java", "-jar", "entreprise-microservice-0.0.1-SNAPSHOT.jar"]