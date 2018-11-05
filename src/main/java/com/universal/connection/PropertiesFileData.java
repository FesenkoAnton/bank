package com.universal.connection;


import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileData {

    private static final Logger logger = Logger.getLogger(PropertiesFileData.class);
    private Properties properties;
    private String pathToProperties = "C:\\Projects\\bank\\src\\main\\resources\\db.properties";

    public PropertiesFileData() {
        getPropertiesConnection();
    }

    public Properties getProperties() {
        return properties;
    }

    private void getPropertiesConnection() {
        properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(pathToProperties);
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                logger.error(e);
            }
        } catch (FileNotFoundException e) {
            logger.error(e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }else{
                    logger.error("Not correct address of path properties");
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }
}