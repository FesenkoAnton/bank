package com.universal.connection;

import com.universal.proper.PropertFilesData;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final Logger logger = Logger.getLogger(ConnectionFactory.class);


    public static Connection getConnection() {
        try {
            Class.forName(PropertFilesData.getDB("DB_DRIVER_CLASS"));
        } catch (ClassNotFoundException e) {
            logger.error(e);
        }
        try {
            return DriverManager.getConnection(PropertFilesData.getDB("DB_URL"),
                    PropertFilesData.getDB("DB_USERNAME"),
                    PropertFilesData.getDB("DB_PASSWORD"));

        } catch (SQLException e) {
            logger.error("Connection to DB is abort ", e);
            throw new RuntimeException("Connection to DB is abort ", e);
        }

    }

}