#Swagger on Eureka Issue
If on your Eureka instance, has been a eureka service application called *unknown*, and the application is using swagger with `@EnableSwagger2Config` annotation, it may the cause. See [this issue](https://github.com/spring-cloud/spring-cloud-netflix/issues/1398]) for more detail.

#Disable Swagger on Production Environment
[Swagger](http://swagger.io/) is indeed (not so) simple yet powerful like its official sites said:

> Swagger is a simple yet powerful representation of your RESTful API.
> With the largest ecosystem of API tooling on the planet, thousands of
> developers are supporting Swagger in almost every modern programming language and deployment environment. With a Swagger-enabled API, you get interactive documentation, client SDK generation and discoverability.

I use Swagger, along with [springfox](http://springfox.github.io/) for documentation. It's so powerful that at same time, you get basic [Postman](https://www.getpostman.com/) along with API documentation. But this is also **dangerous.**

Dangerous when you open your API documentation on production, while API docs should not be shared as so publicly. Irresponsible people might exploit your API, and maybe do some harm.

So, basically swagger docs (either json format or swagger-ui) must be disabled on production environment. Thus, for all swagger config file (Swagger2Config.java), I created two Docket bean, based on active spring profile. Swagger will only be enabled on **dev** profile.

If you want to know more, for each Swagger2Config ([sample](https://github.com/timpamungkas/base-microservice/blob/master/security/src/main/java/com/base/microservice/security/config/Swagger2Config.java)), notice that I have two method that returns Docket, annotated with `@Bean` and `@Profile`. Each will different on `@Profile`, where `@Profile("dev")` will enable swagger using `...build().apiInfo(apiInfo()).enable(true)`

By default, Spring has profile **default** if you don't specify any property on .properties or .yml. In this project, application.yml does not specify spring profile active, thus swagger documentation will not be enabled.

If you need to see swagger documentations, add this line on application.yml:

    spring:
      profiles:
        active: dev

**Just don't forget to delete it on production environment!**
