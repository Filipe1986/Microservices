package filipe.microservice.twiiterconsumer.runner.impl;

import filipe.microservice.twiiterconsumer.config.TwitterConfig;
import filipe.microservice.twiiterconsumer.listener.TwitterListener;
import filipe.microservice.twiiterconsumer.runner.StreamRunner;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.annotation.PreDestroy;
import javax.swing.*;
import java.util.Arrays;

@Component
public class TwitterStreamRunner implements StreamRunner {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(TwitterStreamRunner.class);
    private final TwitterListener twitterListener;
    private final TwitterConfig twitterConfig;
    private TwitterStream twitterStream;


    public TwitterStreamRunner(TwitterListener twitterListener, TwitterConfig twitterConfig) {
        this.twitterListener = twitterListener;
        this.twitterConfig = twitterConfig;
    }

    @Override
    public void start() throws TwitterException {
        twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(twitterListener);
        addFilter();

    }

    @PreDestroy
    public void shutDown(){
        if(twitterStream != null){
            LOG.info("Closing twitter stream");
            twitterStream.shutdown();
        }
    }

    private void addFilter() {
        String [] keywords = twitterConfig.getTwitterKeywords().toArray(new String[0]);
        FilterQuery filter = new FilterQuery(keywords);
        twitterStream.filter(filter);
        LOG.info("Started filtering twitter stream for keywords  {}", Arrays.toString(keywords));
    }
}
