FROM gradle:jdk17-alpine
COPY . /tmp

WORKDIR /tmp
RUN gradle build --no-daemon
EXPOSE 7000
ENTRYPOINT ["java", "-jar","/tmp/build/libs/RSocket_service-0.0.1-SNAPSHOT.jar"]