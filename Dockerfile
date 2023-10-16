FROM maven:3.9.4
COPY ["./src", "./"]
COPY ["pom.xml", "./"]
RUN ["mvn", "install"]

FROM openjdk:17-alpine AS build
RUN ["mkdir", "app"]
WORKDIR /app
COPY ["target/*.jar", "./app.jar"]
EXPOSE 8080
CMD ["java", "-jar", "./app.jar"]