FROM maven:3.5-jdk-8 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:11-jre-slim
ENV JAVA_TOOL_OPTIONS=""
ENV SERVER_PORT=8080
EXPOSE 8080  

COPY --from=build /usr/src/app/target/teams-1.1.0-SNAPSHOT.jar /teams-1.1.0-SNAPSHOT.jar  

RUN adduser --system lbauser
RUN mkdir /var/log/biccw
RUN chown lbauser:nogroup /var/log/biccw/ -R

USER lbauser

ENTRYPOINT ["java","-jar","/teams-1.1.0-SNAPSHOT.jar", "com.gbtec.lba.teams.TeamsApplication"]