//package com.universal.dao;
//
//import org.apache.log4j.Logger;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//public class QueriesSQL {
//
//    private static final Logger logger = Logger.getLogger(QueriesSQL.class);
//
//    private static String propFileName = "C:\\Projects\\bank\\src\\main\\resources\\sqlqueries.properties";
//    private static Properties props;
//
//    public static Properties getQueries(){
////        FileInputStream fileInputStream = null;
////        try {
////            fileInputStream = new FileInputStream(propFileName);
////            try {
////                properties.load(fileInputStream);
////            } catch (IOException e) {
////                logger.error(e);
////            }
////        } catch (FileNotFoundException e) {
////            logger.error(e);
////        }
//        InputStream inputStream =
//                QueriesSQL.class.getResourceAsStream(propFileName);
//        if (inputStream == null){
//            logger.error("Unable to load property file: " + propFileName);
//        }
//        if(props == null){
//            props = new Properties();
//            try {
//                props.load(inputStream);
//            } catch (IOException e) {
//                logger.error(e);
//            }
//        }
//        return props;
//    }
//
//    public static String getQuery(String query){
//        return getQueries().getProperty(query);
//    }
//}
