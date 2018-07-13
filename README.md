# event-service
This application demonstrates the usage of spring boot microservice listening rabbitmq events hosted on cloudamqp.

Requirements
------------
* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)


 Usage 
-----------
* `POST employee-event/{employeeId}` endpoint to get the track of events on a specific employee

Build & Run
-----------
* `mvn spring-boot:run`
* Point your browser to [http://localhost:8081/](http://localhost:8081/)


Documentation
-----------
Api documentation is avaliable at [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
