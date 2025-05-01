package com.securedocs.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GitHubService {
    private static final Logger logger = LoggerFactory.getLogger(GitHubService.class);
    private static final String token = "ghp_92jdslf8923jJKSLAjlskdjkf2390ajsdkljqw0192jdslafj";

    public static void push(String repo, String data) {
        logger.info("Pushing to repo {} with token {}", repo, token);
    }
}
