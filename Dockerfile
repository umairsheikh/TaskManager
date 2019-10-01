FROM oscarfonts/h2
ADD target/Scheduler-Spring-0.0.1-SNAPSHOT.war docker-spring-boot.war
RUN bash -c 'touch /docker-spring-boot.war'
EXPOSE 8080
ENTRYPOINT ["java","-jar","docker-spring-boot.war"]
