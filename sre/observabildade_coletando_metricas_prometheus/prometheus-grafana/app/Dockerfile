FROM openjdk:11-jdk

ARG JAR_FILE=target/*jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Xms512M","-Xmx512M","-XX:PermSize=128m","-XX:MaxPermSize=128m","-Dspring.profiles.active=prod","-jar","/app.jar"]
