# Zuul
This project demonstrate how to connect from UI into Eureka server, and routing api call to appropriate microservice node using Netflix Zuul.

This project will runs on port 8080.

To configure zuul proxy, you need to add lines like this at application.yml

    zuul:
      routes:
        security: /security/**

Example above will routes all request started with "/security" into root path of node named **security** registered on Eureka Server.

As web also an Eureka client, it needs to register itself into running Eureka node, using following configurations at application.yaml

    eureka:
      client:
        serviceUrl:
          defaultZone: http://localhost:8761/eureka/

Now if you go into URL such as http://localhost:8080/security/api/xxxxxx it will actually redirect your request into Eureka server (assuming it is running on port 8761) and in turn redirect your request into **security** node (project **security**).

## Zuul Configuration Reference
See official documentation [here](https://github.com/Netflix/Hystrix/wiki/Configuration#execution.isolation.thread.timeoutInMilliseconds)

## Zuul Timeout
If you ever encountered an issue with stacktrace like this when executing a REST call via zuul proxy:

    ...
    Caused by: java.util.concurrent.TimeoutException: null
    ...

or this

    ...
    java.net.SocketTimeoutException: Read timed out
    ...

Then you need to set zuul timeout (default is 1 second). See stackoverflow issue [here](http://stackoverflow.com/questions/40327631/service-via-zuul-cant-connect-to-gmail/40341898#40341898) and [here](http://stackoverflow.com/questions/28904247/zuul-timing-out-in-long-ish-requests) for solution.

In my case, I configure zuul application.yml to has 30 seconds timeout (works globally) as follows:

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



