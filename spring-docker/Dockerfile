FROM anapsix/alpine-java
WORKDIR /app/
COPY build/libs/*.jar /app/
#EXPOSE 8081

ENTRYPOINT ["top", "-b"]
# ENTRYPOINT ["java", "-jar", "/app/spring-docker-0.0.1.jar"]
