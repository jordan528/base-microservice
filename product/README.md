# Product
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

