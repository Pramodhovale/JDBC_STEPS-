package com.tp;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
//import java.sql.Driver;

public class PlayerService
{
    public static void main(String[] args) throws SQLException {

        String sql = "Insert into player(id,name,run) VALUES (?, ?, ?)";
        // 1.Load and Register
        Driver driver= new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        //2.Establishment connection
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/jdbc_steps","root","root");

        //3.CreateStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,1);
        preparedStatement.setString(2,"ABC");
        preparedStatement.setInt(3,1000);
        int  rowsInserted = preparedStatement.executeUpdate();

        if(rowsInserted>0)
            System.out.println("rows of date is inserted into play table");
        else
            System.out.println("failed to insert the data");

       //close the connection
       connection.close();
    }
}
