FROM openjdk:14-alpine
COPY build/libs/*.jar tourguide-tripdeals-service.jar
EXPOSE 9003
ENTRYPOINT ["java", "-jar", "tourguide-tripdeals-service.jar"]