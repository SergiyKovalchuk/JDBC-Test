package com.jdbctest;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Hi-Tech on 08.05.2017.
 */
public class TestConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection() {
        return connection;
    }

    private Connection connection;

    public TestConnection(){
        try{
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            System.out.println("Не вдалося підключитися");
        }
    }
}
