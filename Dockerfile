FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/NetWhiz_Backend.jar NetWhiz_Backend.jar
EXPOSE 8081
CMD ["java","-jar","NetWhiz_Backend.jar"]