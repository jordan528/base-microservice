# Base Microservice
## What is Microservice?
A good resource about "what is microservice" is available on internet. Follow these links for example:

 - Nginx [tech blog](https://www.nginx.com/blog/introduction-to-microservices/)
 - Ryan Baxter's [blog](http://ryanjbaxter.com/2015/07/13/building-cloud-native-applications/)

##About This Project
Base microservice architecture example. Contains several microservice projects that I'll explain below. Written on Java.

These projects was made using following technology stack:

 - **[Spring Boot](https://projects.spring.io/spring-boot/)**, includes Cloud, Rest, JPA with Hibernate, Security, etc
 - **[Maven](http://maven.apache.org/)**, so it will be easy for you to open in your favorite IDE. I use Eclipse STS, so some files specific for Eclipse STS was included on .gitignore
 - **[Swagger](http://swagger.io/) & [Springfox](http://springfox.github.io/springfox/)** for API documentation. There is a special note about using Swagger on production [here](https://github.com/timpamungkas/base-microservice/blob/master/documentations/swagger.md)
 - **[Lombok](https://projectlombok.org/)** so your code will less verbose

You don't have to be a Java expert to read the source, but you need to know how to code with Java, and better yet if you already know Spring MVC and Spring JPA with Hibernate.
If you don't have any experience with Java / Spring, I suggest you go to [udemy](http://udemy.com/) or [udacity](https://www.udacity.com/) and take their free course.

The project was built using [Spring Cloud](http://projects.spring.io/spring-cloud/) stack for microservice, includes sample Netflix Eureka server. To get optimal demo experience will took a moment. Just follow this sequence:

 1. Start eureka
 2. Start zuul
 3. Start all other services, sequence doesn't matter. For each service will take about 30 seconds until zuul recognized endpoint mapping.

The project intended to give brief description about microservice architecture on [Spring](https://spring.io/) technology stack.

For development ease, all services will be defaulted to run on localhost, with different ports. You can configure this settings on each individual project configuration file (application.yml)

Below is the list of project available in this repo. See detailed description for each project in their own readme.

##Folder : Documentations
More documentation for those who don't mind read it:
 - [Disable Swagger on Production Environment](https://github.com/timpamungkas/base-microservice/blob/master/documentations/swagger.md)
 - [Using this repo for starter project](https://github.com/timpamungkas/base-microservice/blob/master/documentations/starter-project.md)

##Project : Eureka
Netflix eureka server using Spring Cloud, running on port 8761. See this project for sample spring cloud-netflix discovery service using [Eureka](https://spring.io/guides/gs/service-registration-and-discovery/).

##Project : Zuul
Basic reverse proxy using Spring Cloud, running on port 8080. See this project for sample spring cloud-netflix reverse proxy using [Zuul](https://spring.io/guides/gs/routing-and-filtering/).

##Project : Security
Sample rest client for security, running on port 8181. See this project for sample spring [security](http://projects.spring.io/spring-security/).

##Project : Category
Sample rest client for shop categories, running on port 8182. See this project for sample spring REST inter-process communication using RestTemplate with running Eureka.

##Project : Product
Sample rest client for shop products, running on port 8183

##Project : Email
Sample rest client for email utilities, running on port 8184. See this project for sample [spring boot mail](http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-email.html) for gmail.
