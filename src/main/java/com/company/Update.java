package com.company;

import java.sql.*;

public class Update
{
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc_Steps";
        String user = "root";
        String pass = "root";

        String sql = "Update JDBC_steps.company set name=? , salary=? where id=1";

        //1.Load and Register the Driver
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        //2.Establish the connection
        Connection connection = DriverManager.getConnection(url, user, pass);

        //3.Create a statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,"PQR");
        preparedStatement.setDouble(2,200.00);
        int i = preparedStatement.executeUpdate();

        System.out.println(i+ " record UPDATED!");

    }
}
