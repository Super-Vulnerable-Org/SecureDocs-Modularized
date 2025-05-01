package com.securedocs.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreditAPI {
    private static final Logger logger = LoggerFactory.getLogger(CreditAPI.class);
    private static final String token = "Bearer 23jk89skQWIklsy2782NmvpaYY8GJksqLAHJAKL0198yqwq298HJAJ";

    public static String fetchScore(String userId) {
        logger.info("Calling Experian for user {} with token {}", userId, token);
        return "Score: 782";
    }
}
