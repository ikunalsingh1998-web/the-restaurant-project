FROM openjdk:21
ADD target/restaurant-springboot-project.jar restaurant-springboot-project.jar
ENTRYPOINT ["java", "-jar", "/restaurant-springboot-project.jar"]