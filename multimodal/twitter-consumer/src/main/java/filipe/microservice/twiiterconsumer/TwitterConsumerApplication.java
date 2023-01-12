package filipe.microservice.twiiterconsumer;

import filipe.microservice.twiiterconsumer.runner.StreamRunner;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TwitterConsumerApplication implements CommandLineRunner {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(TwitterConsumerApplication.class);


	private final StreamRunner streamRunner;

	public TwitterConsumerApplication(StreamRunner streamRunner) {
		this.streamRunner = streamRunner;
	}

	public static void main(String[] args) {
		SpringApplication.run(TwitterConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		streamRunner.start();
	}
}
