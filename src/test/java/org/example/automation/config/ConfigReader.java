package org.example.automation.config;

import java.io.InputStream;
import java.util.Properties;

/**
 * Reads configuration properties from the config.properties file located in the resources folder.
 * Provides methods to retrieve string and integer properties with optional default values.
 */
public class ConfigReader {
    /**
     * Static properties instance loaded from the config.properties file.
     * Used to store and retrieve configuration values for the automation framework.
     */
    private static final Properties properties = new Properties();

    /**
     * Static initialization block that loads configuration properties from the classpath.
     * Throws a RuntimeException if the config.properties file is not found or fails to load.
     */
    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("No se encontró el archivo config.properties en src/test/resources/");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar el archivo de configuración config.properties", e);
        }
    }

    /**
     * Retrieves the value of a configuration property by key.
     *
     * @param key the configuration property key
     * @return the property value, or null if the key is not found
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Retrieves the value of a configuration property by key, with a default value if the key is not found.
     *
     * @param key          the configuration property key
     * @param defaultValue the default value to return if the key is not found
     * @return the property value or the default value
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Retrieves an integer configuration property by key, with a default value if the key is not found or invalid.
     *
     * @param key          the configuration property key
     * @param defaultValue the default value to return if the key is not found or cannot be parsed
     * @return the integer property value, or the default value
     */
    public static int getIntProperty(String key, int defaultValue) {
        String value = properties.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        return Integer.parseInt(value);
    }
}