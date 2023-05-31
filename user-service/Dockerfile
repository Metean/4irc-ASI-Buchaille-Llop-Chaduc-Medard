# Stage 1: Build and install the DTO project into local maven repository
FROM maven:3.8.3-openjdk-17 AS app-builder

WORKDIR /dto

# Copy your DTO project
COPY ./dto/pom.xml ./pom.xml
COPY ./dto/src ./src

# Build the DTO project and install it into the local maven repository
RUN mvn clean install -DskipTests

WORKDIR /app

# Copy your main project
COPY ./user-service/pom.xml ./pom.xml
COPY ./user-service/src ./src

# Build the main project with the dependencies
RUN mvn clean package -DskipTests

# Stage 2: Copy the artifact and run
FROM openjdk:17-jdk-slim as app-runner
WORKDIR /app

COPY --from=app-builder /app/target/asi-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java","-jar","app.jar"]
