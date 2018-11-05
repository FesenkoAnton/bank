package com.universal.connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class ConnectPool {
    private static final Logger logger = Logger.getLogger(ConnectPool.class);
    private final int MAX_CONNECT = 5;
    private List<Connection> connectArray = new ArrayList<>();

    ConnectPool() {
        fullConnectPool();
    }

    private void fullConnectPool() {
        while (poolIsFull()) {
            connectArray.add(ConnectionFactory.getConnection());
        }
    }

    private synchronized boolean poolIsFull() {
        if (connectArray.size() < MAX_CONNECT) {
            return true;
        }
        return false;
    }

    public synchronized Connection getFromPoolCon() {
        Connection connection = null;
        if (connectArray.size() > 0) {
            connection = connectArray.get(0);
            connectArray.remove(0);
        } else {
            logger.error("Reached the maximum of the pool.");
        }
        return connection;
    }

    public synchronized void connectToPool(Connection connection) {
        if (connectArray.size() < 5) {
            connectArray.add(connection);
        } else {
            logger.error("try do connectArray.size > max value.");
        }
    }


}