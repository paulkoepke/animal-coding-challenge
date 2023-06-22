#building step
FROM maven:3-openjdk-17-slim AS builder

#setting work directory
WORKDIR /app

#copy the pom file
COPY pom.xml .

#install dependencies
RUN mvn dependency:go-offline -B

#copy source files
COPY src ./src

#build project
RUN mvn package -DskipTests

#running step
FROM openjdk:17-jdk-slim

#setting work directory
WORKDIR /app

#copy the previously build files
COPY --from=builder /app/target/*.jar ./app.jar

#expose port
EXPOSE 8080

#run app
CMD ["java", "-jar", "app.jar"]
