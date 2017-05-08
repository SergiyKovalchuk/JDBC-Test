package com.jdbctest;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Hi-Tech on 05.05.2017.
 */
public class JDBCTest {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.out.println("Не вдалося підключитися");
        }

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); Statement statement = connection.createStatement()) {

            //statement.execute("INSERT INTO users (name,age, email) VALUES ('Jon', 18, 'ex5@gmail.com')");

            //statement.executeUpdate("UPDATE users SET name = 'New Jon' WHERE id = 5 ");

            //ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            /*
            statement.addBatch("INSERT INTO users (name,age, email) VALUES ('Jon1', 19, 'ex6@gmail.com')");
            statement.addBatch("INSERT INTO users (name,age, email) VALUES ('Jon2', 20, 'ex7@gmail.com')");
            statement.addBatch("INSERT INTO users (name,age, email) VALUES ('Jon3', 21, 'ex8@gmail.com')");
            statement.executeBatch();
            statement.clearBatch();
            */

            boolean status = statement.isClosed();
            System.out.println(status);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
