FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/billet-api-0.0.1-SNAPSHOT.jar billet-api.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar billet-api.jar" ]