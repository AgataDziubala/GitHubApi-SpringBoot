# GitHubApi-SpringBoot

A Spring Boot application twhich acquires data from GitHub REST API v3 and saves users to database. The application also displays statistics of given User (e.g., followers, days on GitHub, number of repos).

## Running

### Configure MySQL

1. Create a database in your MySQL instance.
2. Update the application.properties file in the src/main/resources folder with the URL, username and password for your MySQL instance. 

### Build and run the application

1. `mvn package spring-boot:run`
2. Open a web browser to `http://localhost:8080`


## Technologies and tools
* [Java SDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [MySQL](https://www.mysql.com/)
* [JUnit](https://junit.org/junit4/)
* [Mockito](http://site.mockito.org/)
* [Thymeleaf] (https://www.thymeleaf.org/)
* [Bootstrap](https://getbootstrap.com/)
