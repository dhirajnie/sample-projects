FROM java:8-jdk-alpine
COPY ./target/docker-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch docker-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","docker-0.0.1-SNAPSHOT.jar"]


