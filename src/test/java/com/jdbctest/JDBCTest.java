package com.jdbctest;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Hi-Tech on 05.05.2017.
 */
public class JDBCTest {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {


        Connection connection;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if(!connection.isClosed())
                System.out.println("Звязок з БД встановленно!");

            connection.close();

            if(connection.isClosed())
                System.out.println("Звязок з БД закрито!");

        } catch (SQLException e) {
            System.out.println("Не вдалося підключитися");
        }

    }


}
