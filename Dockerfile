FROM openjdk:11
EXPOSE 8080
ADD target/assessment-0.0.1-SNAPSHOT.jar assessment-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","assessment-0.0.1-SNAPSHOT.jar"]