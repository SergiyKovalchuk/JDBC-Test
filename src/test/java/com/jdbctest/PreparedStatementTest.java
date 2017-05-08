package com.jdbctest;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

/**
 * Created by Hi-Tech on 08.05.2017.
 */
public class PreparedStatementTest {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String  NEW_INSERT = "INSERT INTO dish VALUES(?,?,?,?,?,?,?)";
    private static final String  GET_ALL = "SELECT * FROM dish";


    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{

            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            /*preparedStatement = connection.prepareStatement(NEW_INSERT);

            preparedStatement.setInt(1,2);
            preparedStatement.setString(2, "Title");
            preparedStatement.setString(3, "Description");
            preparedStatement.setFloat(4, 3.14f);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setBlob(7, new FileInputStream("smile.png"));

            preparedStatement.execute();*/

            preparedStatement = connection.prepareStatement(GET_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String desc = resultSet.getString("description");
                float rating = resultSet.getFloat("rating");
                boolean pub = resultSet.getBoolean("publised");
                Date date = resultSet.getDate("created");
                byte[] icon = resultSet.getBytes("icon");

                System.out.println("id: " + id + " title: " + title + " description: " + desc
                + " raiting: " + rating + " publised: " + pub + " created: " + date + " icon: " + icon);

            }

        } catch (SQLException/*|FileNotFoundException*/ e) {
            e.printStackTrace();
        }
    }

}
