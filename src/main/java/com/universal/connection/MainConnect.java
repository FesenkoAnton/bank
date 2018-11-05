package com.universal.connection;

import java.sql.Connection;

public class MainConnect {

    private static ConnectPool connectPool = new ConnectPool();

    public static Connection getConnect(){
        Connection connection = connectPool.getFromPoolCon();
        return connection;
    }

    public static void putConn(Connection connection){
        connectPool.connectToPool(connection);
    }

}