FROM openjdk:10-jdk
ADD ./target/spring-boot-kafka-producer-example-0.0.1-SNAPSHOT.jar /usr/src/spring-boot-kafka-producer-example-0.0.1-SNAPSHOT.jar
WORKDIR usr/src	
EXPOSE 9091
ENTRYPOINT ["java","-jar", "/usr/src/spring-boot-kafka-producer-example-0.0.1-SNAPSHOT.jar"]

