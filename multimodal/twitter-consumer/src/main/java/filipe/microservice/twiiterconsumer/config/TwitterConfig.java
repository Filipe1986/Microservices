package filipe.microservice.twiiterconsumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
@Data
@ConfigurationProperties(prefix = "twitter-to-kafka-service")
public class TwitterConfig {

    private List<String> twitterKeywords;
}
