FROM openjdk:11-alpine
VOLUME /tmp
COPY target/distributedusers-0.0.1-SNAPSHOT.jar distributedusersapp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/distributedusersapp.jar"]