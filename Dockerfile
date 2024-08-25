FROM openjdk:17-jdk-alpine
MAINTAINER EM
COPY target/test-0.0.1-SNAPSHOT.jar Task-Management-1.0.0.jar
ENTRYPOINT ["java","-jar","/Task-Management-1.0.0.jar"]