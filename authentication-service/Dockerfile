# Stage 1: Build and install the DTO project into local maven repository
FROM maven:3.8.3-openjdk-17 AS dto-builder
WORKDIR /dto

# Copy your DTO project
COPY ./dto/pom.xml ./pom.xml
COPY ./dto/src ./src

# Build the DTO project and install it into the local maven repository
RUN mvn clean install

# Stage 2: Build your main project
FROM maven:3.8.3-openjdk-17 AS app-builder
WORKDIR /app

# Copy your main project
COPY ./authentication-service/pom.xml ./pom.xml
COPY ./authentication-service/src ./src

# Build the main project with the dependencies
RUN mvn clean package -DskipTests

# Stage 3: Copy the artifact and run
FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=app-builder /app/target/asi-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java","-jar","app.jar"]
