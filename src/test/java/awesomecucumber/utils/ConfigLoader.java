package awesomecucumber.utils;

import awesomecucumber.constants.Environment;

import java.util.Properties;

public class ConfigLoader {
    private static ConfigLoader configLoader = null;
    private final Properties properties;

    private ConfigLoader() {
        String env = System.getProperty("env", String.valueOf(Environment.STAGE));
        switch (Environment.valueOf(env)) {
            case STAGE -> {
                properties = PropertyUtils.propertyLoader("src\\test\\resources\\config_STAGE.properties");
            }
            case PROD -> {
                properties = PropertyUtils.propertyLoader("src\\test\\resources\\config_PROD.properties");
            }
            default -> throw new IllegalArgumentException("INVALID ENV TYPE IS PROVIDED " + env);
        }

    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl() {
        String baseUrl = properties.get("baseUrl").toString();
        if (baseUrl == null)
            throw new RuntimeException(baseUrl + " is not present in properties file");
        return baseUrl;
    }
}
