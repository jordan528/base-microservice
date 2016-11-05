# Eureka
Basic implementation of service discovery using Spring Cloud.
 This project will runs on localhost:8761.
Configuration files are Spring Boot yml files:

 - bootstrap.yml 
 - application.yml

Few good starting points for writing Eureka server is:
 
 - [spring guide](https://spring.io/guides/gs/service-registration-and-discovery/)
 - Ryan Baxter's [blog](http://ryanjbaxter.com/2015/09/21/building-cloud-native-apps-with-spring-part-2/)
 - Netflix [github repo](https://github.com/spring-cloud/spring-cloud-netflix/blob/master/docs/src/main/asciidoc/spring-cloud-netflix.adoc#service-discovery-eureka-server)

It is very easy to setup basic Eureka server, just use `@EnableEurekaServer` on your spring boot application, configure a little yaml, and you have live basic-level service discovery up and running.
