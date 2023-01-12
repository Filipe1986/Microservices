package filipe.microservice.twiiterconsumer.controller;

import filipe.microservice.twiiterconsumer.config.TwitterConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/twitter-consumer")
public class Controller {

    private final TwitterConfig twitterConfig;

    private static final Logger LOG = LoggerFactory.getLogger(Controller.class);

    Controller(TwitterConfig twitterConfig){
        this.twitterConfig = twitterConfig;
    }

    @GetMapping()
    public ResponseEntity<?> ok() {

        twitterConfig.getTwitterKeywords().forEach(LOG::info);
        return ResponseEntity.ok(twitterConfig.getTwitterKeywords());
    }


}
