FROM adoptopenjdk:11-jre-hotspot
MAINTAINER baeldung.com

ADD target/flight_service-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]