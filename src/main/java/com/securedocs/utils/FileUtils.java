package com.securedocs.utils;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    public static String readRawFile(String filePath) throws Exception {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static String readWhitelistedFile(String filePath) throws Exception {
        if (filePath.contains("..") || filePath.contains("/") || filePath.contains("\\")) {
            throw new IllegalArgumentException("Invalid path");
        }
        String basePath = "/opt/securedocs/";
        return new String(Files.readAllBytes(Paths.get(basePath + filePath)));
    }
}
