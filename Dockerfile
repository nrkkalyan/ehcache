# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:8-jdk-alpine
VOLUME /tmp

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} my-app.jar

# Usage: docker run -p XXXX:YYYY -e "JAVA_OPTS=-Dspring.profiles.active=test -Ddebug -Xmx128m" <tag>
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /my-app.jar"]