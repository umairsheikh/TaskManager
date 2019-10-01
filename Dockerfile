FROM oscarfonts/h2
ADD target/Scheduler-Spring-0.0.1-SNAPSHOT.war taskmanager.war
RUN bash -c 'touch /taskmanager.war'
EXPOSE 8080
ENTRYPOINT ["java","-jar","taskmanager.war"]