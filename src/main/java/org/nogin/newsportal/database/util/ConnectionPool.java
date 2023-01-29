package org.nogin.newsportal.database.util;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;

public class ConnectionPool {
    private final String jdbcUrl;
    private final String username;
    private final String password;
    private final String driver;
    private final ArrayBlockingQueue<Connection> connections;

    public ConnectionPool(String jdbcUrl, String username, String password, String driver, int minConnections, int maxConnections) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
        this.driver = driver;
        connections = new ArrayBlockingQueue<>(maxConnections);
        for (int i = 0; i < minConnections; i++) {
            connections.add();
        }
    }

    @PostConstruct
    public void initializeConnectionPool() {
        
    }

    private Connection connection() {
        try {
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
