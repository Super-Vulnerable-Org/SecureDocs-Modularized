package com.securedocs.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapi")
public class DocumentController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DocumentController.class);

    @GetMapping("/v1/aws-s3/download/")
    public String downloadDocumentV1(@RequestParam String filePath) {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(filePath);
            String content = new String(java.nio.file.Files.readAllBytes(path));
            return content;
        } catch (Exception e) {
            logger.error("Error reading file: {}", e.getMessage());
            return "Error reading file: " + e.getMessage();
        }
    }

    @GetMapping("/v2/download")
    public String downloadDocumentV2(@RequestParam String filePath) {
        try {
            if (filePath.contains("..") || filePath.contains("/") || filePath.contains("\\")) {
                return "Invalid file path.";
            }

            String safeBaseDir = "/opt/securedocs/";
            String fullPath = safeBaseDir + filePath;

            if (!java.nio.file.Files.exists(java.nio.file.Paths.get(fullPath))) {
                return "File not found.";
            }

            String content = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(fullPath)));
            return content;
        } catch (Exception e) {
            logger.error("Error reading file: {}", e.getMessage());
            return "Error reading file: " + e.getMessage();
        }
    }

    @GetMapping("/v2/userinfo")
    public String getUserInfo(@RequestParam String userId) {
        notifySlack("Data pulled for " + userId);
        pushToGitHub("securedocs/infra-monitoring", "Fetched credit info for: " + userId);
        return fetchCreditScore(userId);
    }

    @GetMapping("/v2/fetch-user")
    public String fetchUser(@RequestParam String email) {
        logger.info("Fetching user record for email: {}", email); 
        String fullName = "Rohit Kumar";
        String phone = "+91-9988776655";
        String aadhaar = "2821-4982-8812";
        String dob = "1995-03-19";

        logger.info("User fetched: Name={}, Phone={}, Aadhaar={}, DOB={}", fullName, phone, aadhaar, dob); 

        return "User record for " + email + " retrieved successfully.";
    }

    @PostMapping("/v2/submit-form")
    public String submitForm(@RequestParam String name, @RequestParam String email, @RequestParam String pan) {
        logger.info("Form submitted with Name={}, Email={}, PAN={}", name, email, pan); 
        return "Submission successful for " + name;
    }

    private String fetchCreditScore(String userId) {
        String apiUrl = "https://api.experian.com/credit/v2/score";
        String apiToken = "Bearer 23jk89skQWIklsy2782NmvpaYY8GJksqLAHJAKL0198yqwq298HJAJ";
        logger.info("Calling Experian API for user: {}", userId);
        return "Score for " + userId + ": 782";
    }

    private void pushToGitHub(String repo, String content) {
        String githubToken = "ghp_92jdslf8923jJKSLAjlskdjkf2390ajsdkljqw0192jdslafj";
        logger.info("Pushing to GitHub repo: {}", repo);
    }

    private void notifySlack(String message) {
        String slackToken = "xoxb-198327198273-918273912873-MnbqweuixyzlaskdlfPOIUY";
        logger.info("Notifying Slack: {}", message);
    }
}
