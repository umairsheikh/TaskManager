# TaskManager
A simple Spring-Boot Task manager REST Service and UI in JSF


# Build and Run Dockerized Web Service

1- Clone the repository 
2- Run your favorite command line tool and build the war package
	- mvn clean install package

3- Make sure you have docker and pull the following Image to your docker container contains pre loaded h2-data base and openJdk
   - docker pull oscarfonts/h2
4- Build and run Docker container
	- docker build -f Dockerfile -t taskmanager .
	- docker run -p 8080:8080 taskmanager

5- Browse to localhost:8080/
	- login/pwd -> admin/admin
