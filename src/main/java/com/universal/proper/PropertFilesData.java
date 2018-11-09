package com.universal.proper;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertFilesData {

    private static final Logger logger = Logger.getLogger(PropertFilesData.class);

    private static Properties properties;
    private static String propFileNameDB = "C:\\Projects\\bank\\src\\main\\resources\\db.properties";

    private static String propFileNameSQLCommand = "C:\\Projects\\bank\\src\\main\\resources\\sqlqueries.properties";


//    public PropertFilesData() {
//        getPropertiesConnection();
//    }

    public static Properties getProperties() {
        return properties;
    }

    private static void getPropertiesConnection(String propFileName) {
        properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(propFileName);
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
    public static String getQuery(String query){
        getPropertiesConnection(propFileNameSQLCommand);
        return getProperties().getProperty(query);
    }

    public static String getDB(String query){
        getPropertiesConnection(propFileNameDB);
        return getProperties().getProperty(query);
    }
}
