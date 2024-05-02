package com.corserv.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties;

    public ConfigLoader(String propertiesFilePath) {
        properties = new Properties();
        try {
            // Loads properties from the file at the specified path
            properties.load(new FileInputStream(propertiesFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + propertiesFilePath, e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
