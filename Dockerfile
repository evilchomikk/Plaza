FROM amazoncorretto:21
RUN mkdir /plaza
COPY build/libs/plaza-0.0.1-SNAPSHOT.jar plaza-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "plaza-0.0.1-SNAPSHOT.jar"]

