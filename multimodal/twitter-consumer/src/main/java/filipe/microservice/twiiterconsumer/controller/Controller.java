package filipe.microservice.twiiterconsumer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/twitter-consumer")
public class Controller {

    @GetMapping()
    public ResponseEntity<?> ok() {
        return ResponseEntity.ok("Twitter Service");
    }


}
