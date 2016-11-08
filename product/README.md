# Product
Example of REST service-to-service call using Netflix [Feign Client](https://github.com/spring-cloud/spring-cloud-netflix/blob/master/docs/src/main/asciidoc/spring-cloud-netflix.adoc#declarative-rest-client-feign). At this example, when a product was created, an email will be sent.
Email is available on project [email](https://github.com/timpamungkas/base-microservice/tree/master/email) (different service), so when you call product endpoint (*/api/product/save*), a call to email service will be made to send email.

## Running The Examples

1. Make sure that eureka is running
2. Make sure that zuul is running
3. Configure project email's [application.yml](https://github.com/timpamungkas/base-microservice/blob/master/email/src/main/resources/application.yml) for your email settings
4. Run project email
5. Change recipient address on [product REST controller](https://github.com/timpamungkas/base-microservice/blob/master/product/src/main/java/com/base/microservice/product/controller/ProductRestController.java)
6. Run project product
7. Wait about 30 seconds after live for both service register themself on eureka / zuul
8. Hit this endpoint using POST : http://localhost:8080/product/api/product/save
9. Email will be sent

## Worth to look
See following files:
* [Feign Client](https://github.com/timpamungkas/base-microservice/blob/master/product/src/main/java/com/base/microservice/product/client/rest/EmailRestClient.java)
* [Service implementation](https://github.com/timpamungkas/base-microservice/blob/master/product/src/main/java/com/base/microservice/product/service/impl/EmailSenderServiceImpl.java) calling feign client

----------

See this code on [EmailSenderServiceImpl](https://github.com/timpamungkas/base-microservice/blob/master/product/src/main/java/com/base/microservice/product/service/impl/EmailSenderServiceImpl.java)?
`@HystrixCommand(fallbackMethod = "emailFallback")`
That is [circuit breaker](http://martinfowler.com/bliki/CircuitBreaker.html) handler, in case email service is down. In such case, we can add fallback handler using [hystrix](https://github.com/spring-cloud/spring-cloud-netflix/blob/master/docs/src/main/asciidoc/spring-cloud-netflix.adoc#circuit-breaker-hystrix-clients) to propagate failed method to default error handler, in this case is `methodFallback()`.

## Zuul Timeout
If you ever encountered an issue with stacktrace like this when executing a REST call via feign client:

    ...
    Caused by: java.util.concurrent.TimeoutException: null
    ...

or this

    ...
    java.net.SocketTimeoutException: Read timed out
    ...

Then you need to set feign client timeout (default is 1 second). See stackoverflow issue [here](http://stackoverflow.com/questions/40327631/service-via-zuul-cant-connect-to-gmail/40341898#40341898), [here](https://github.com/spring-cloud/spring-cloud-netflix/issues/696), and [here](http://stackoverflow.com/questions/28904247/zuul-timing-out-in-long-ish-requests) for solution.

In my case, I configure product application.yml to has 30 seconds timeout for feign call. Configuration as follows:

    hystrix:
      command:
        default:
          execution:
            isolation:
              thread:
                timeoutInMilliseconds: 30000
    ribbon:
      ReadTimeout: 30000
      ConnectTimeout: 30000


