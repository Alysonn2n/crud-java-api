FROM maven:3.9.4
COPY pom.xml ./
COPY ./src ./
RUN ["mvn", "install"]

FROM openjdk:17-alpine AS build
RUN mkdir app
WORKDIR /app
COPY target/*.jar app.jar