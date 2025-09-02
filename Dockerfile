FROM maven:latest AS build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package -DskipTests

FROM openjdk:17
COPY --from=build /tmp/target/spring-demo.jar spring-demo.jar
ENTRYPOINT ["java","-jar","spring-demo.jar"]