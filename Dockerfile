FROM ubuntu:latest
LABEL authors="Kulka"
WORKDIR /plaza
EXPOSE 8080
COPY target/plaza.jar plaza.jar
ENTRYPOINT ["top", "-b"]
CMD ["java", "-jar", "plaza.jar"]