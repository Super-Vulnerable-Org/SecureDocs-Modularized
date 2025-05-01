package com.securedocs.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlackService {
    private static final Logger logger = LoggerFactory.getLogger(SlackService.class);
    private static final String token = "xoxb-198327198273-918273912873-MnbqweuixyzlaskdlfPOIUY";

    public static void send(String msg) {
        logger.info("Slack message: {}", msg);
    }
}
