package awesomecucumber.utils;

import okio.Buffer;

import java.io.*;
import java.util.Properties;

public class PropertyUtils {
    public static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            try {
                properties.load(bufferedReader);
            } catch (IOException ioException) {
                throw new RuntimeException("Unable to load properties file");
            }
        } catch (IOException ioException) {
            throw new RuntimeException("Properties file not found " + filePath);
        }
        return properties;
    }
}
