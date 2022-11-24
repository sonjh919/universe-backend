FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]
ENTRYPOINT ["java", "-Xms1024M", "-Xmx1024M", "-jar", "/app.jar"]