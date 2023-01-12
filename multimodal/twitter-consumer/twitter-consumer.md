# Twitter Consumer

* it uses:
    - jib for docker images.


* To run the project add the twitter4j.properties inside:
  - multimodal/twitter-consumer/src/main/resources/twitter4j.properties

## Twitter 
  - https://developer.twitter.com/en
  - https://twitter4j.org/



### Commands

To generate image
```shell
make image
```


To run the app on docker
```shell
make app
```

To stop the app on docker
```shell
make down
```

To open controller service
```shell
xdg-open http://localhost:8081/twitter-consumer
```