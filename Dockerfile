FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/spring-web-flux-0.0.1-SNAPSHOT.jar spring-web-flux.jar
ADD target/spring-web-flux-0.0.1-SNAPSHOT.jar spring-web-flux.jar
ENTRYPOINT ["java","-jar","/spring-web-flux.jar"]