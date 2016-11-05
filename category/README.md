#Category
Sample rest client for shop categories, running on port 8182. See this project for sample spring REST inter-process communication using RestTemplate with running Eureka.

To call other service, we can use Spring [RestTemplate](https://spring.io/guides/gs/consuming-rest/). However, instead of hardcoded URL during [RestTemplate](https://spring.io/guides/gs/consuming-rest/) call, we can use alias from Eureka, or zuul proxy.


----------


##Notable areas in this project
### No DRY, No Problem
If you follow project [email](https://github.com/timpamungkas/base-microservice/tree/master/email), you'll notify that this project has exact same class regarding email. See [here](https://github.com/timpamungkas/base-microservice/tree/master/category/src/main/java/com/base/microservice/category/model) and [there](https://github.com/timpamungkas/base-microservice/tree/master/email/src/main/java/com/base/microservice/email/model) (project email). This is how it meant to be.
I copy Ryan Baxter [explanation](http://ryanjbaxter.com/2015/10/01/building-cloud-native-apps-with-spring-part-4/) below with a little adjustment:

> If you are a seasoned Java developer, your first instinct will
> probably be to do some refactoring.  You might go to the email,
> service extract out the Email package into its own project.  Then you
> would change the email and category service so they depend on this 
> project.  This has been engrained in our minds due to the DRY (do not
> repeat yourself) principal, which says we should not be copying and
> pasting code all over the place due to the fact that it will become
> hard to maintain.  This is certainly a valid concern, however we have
> to balance the DRY principal along with other principals of
> microservices.  The problem with this approach to refactoring our
> application is that we now have a common class used by 2 (or more)
> services.  What happens when one service needs to make a change to
> that class?  If the change is drastic enough, you can break the other
> service.  This means that the services can’t evolve independently of
> each other, which is one of the benefits we are trying to achieve by
> using microservices.
> 
> At the end of the day you have to make a decision that is right for
> you, your team, and your project.  Do you want to share code between
> your microservices or do you want the benefit of being able to evolve
> your services independently of each other?  In this case we will NOT
> follow the DRY principal and create a new Email package in our
> category service.  

> Why?  Think about how you would be working if you were
> building a real production grade microservices application.  You would
> be a developer on a team that is responsible for a single service.  In
> theory you will know nothing about the implementations of other
> services you depend on, the only thing you can rely on is their public
> API.  They may not even be implemented in the same language that you
> are using.  Based on that logic, it makes sense for you to create a
> Participant class in your service which corresponds to what their
> public API will return.  In my opinion, when it comes to
> microservices, sharing code between services does not generally make
> sense.

###No Hardcoded URL or IP Address
Calling email service were actually done in this [class](https://github.com/timpamungkas/base-microservice/blob/master/category/src/main/java/com/base/microservice/category/service/impl/EmailSenderServiceImpl.java), using RestTemplate. See that to call the email service, I don't use URL (http://localhost:8184) nor  IP (http://127.0.0.1:8184).
This can actually done because in [this project](https://github.com/timpamungkas/base-microservice/tree/master/eureka), we use Eureka as service discovery. So, as long as following prerequisites were fulfilled, you can refer Eureka service name:

 1. Eureka server is up and running
 2. Both Category and Email service is registered on running Eureka (via `@EnableDiscoveryClient` or `@EnableEurekaClient`). For this project, email was registered as under name **email** as written in email's [bootstrap.yml](https://github.com/timpamungkas/base-microservice/blob/master/email/src/main/resources/bootstrap.yml)
 3. Email service is up and running

Then you can call email service through  http://**email**/[endpoint] instead of http://**localhost:8184**/[endpoint].

Even more interesting, since I also use Zuul as reverse proxy. Assuming Eureka and Zuul alive, you can call email service via Zuul with this address : http://**zuul/email**/[endpoint]. See, even Zuul is a registered service, so we don't need to write Zuul address if call it on same running Eureka server.
