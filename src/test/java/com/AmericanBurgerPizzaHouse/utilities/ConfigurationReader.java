package com.AmericanBurgerPizzaHouse.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            //which file to read
            String path = "configuration.properties";

            //reads the file into java
            FileInputStream input = new FileInputStream(path);

            //properties -> this class store properties in key / value format
            properties = new Properties();

            //the values from the input is loaded/ fed into the properties object
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

}
