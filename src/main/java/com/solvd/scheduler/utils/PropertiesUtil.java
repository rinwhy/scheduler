package com.solvd.scheduler.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertiesUtil provides utility methods for retrieving properties for a configuration file
 */
public class PropertiesUtil {

    private static final Logger LOGGER = LogManager.getLogger(PropertiesUtil.class);


    public static Properties getProperties(){
        Properties properties = new Properties();
        try {
            InputStream input = new FileInputStream("src/main/resources/db.properties");
            properties.load(input);
        } catch (FileNotFoundException e) {
            LOGGER.warn("Error finding the file\n" + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            LOGGER.warn("IO Exception!! \n" + e.getMessage());
            throw new RuntimeException(e);
        }
        return properties;
    }
}