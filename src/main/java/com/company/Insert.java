package com.company;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://localhost:3306/jdbc_steps";
        String user="root";
        String pass="root";
        String sql="Insert into company(id,name,salary) values (?,?,?);";

        //1.Load and Register the driver
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        //2.Establish the connection
        Connection connection = DriverManager.getConnection(url,user,pass);

        //3.Create a statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,1);
        preparedStatement.setString(2,"ABC");
        preparedStatement.setDouble(3,100.0);
        int inrowsdetailsareinserted = preparedStatement.executeUpdate();

        if(inrowsdetailsareinserted>0)
        {
            System.out.println("Records are inserted");
        }
        else
        {
            System.out.println("Records are not inserted");
        }

        connection.close();
        preparedStatement.close();
    }
}
