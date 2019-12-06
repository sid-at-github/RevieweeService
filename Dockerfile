FROM openjdk:8-jre-alpine
COPY target/RevieweeService-1.0.jar /RevieweeService-1.0.jar
CMD ["/usr/bin/java", "-jar", "/RevieweeService-1.0.jar"]