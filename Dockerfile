FROM openjdk:17-jdk-alpine
MAINTAINER EM
COPY target/test-0.0.1-SNAPSHOT.jar test-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/test-0.0.1-SNAPSHOT.jar"]
