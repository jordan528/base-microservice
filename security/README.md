# Security
Sample REST security implementation using

 - Spring webmvc
 - Spring security
 - Spring cloud
 - Spring JP & in-memory H2 database for temporary storage

This project will runs on port 8181.
If your Eureka and Zuul already runs, then you can access this project at **localhost:8080/security**
To access REST API documentation, access localhost:8080/security/swagger-ui.html

Basic security using http basic auth was enabled on URL started with **/api/secure/**