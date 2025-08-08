package com_ui_testing_utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class configReader {

    private static Properties prop;
    private static final Logger log = LogManager.getLogger(configReader.class);

    public static void loadConfig() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop = new Properties();
            prop.load(fis);
            log.info("Configuration file loaded successfully.");
        } catch (IOException e) {
            log.error("Failed to load config.properties file", e);
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String get(String key) {
        if (prop == null) {
            log.error("Configuration not loaded. Call loadConfig() first.");
            throw new IllegalStateException("Config file not loaded. Call loadConfig() first.");
        }
        String value = prop.getProperty(key);
        log.debug("Fetching property: {} = {}", key, value);
        return value;
    }
}
