package com.company;

import java.sql.*;

public class Retrive {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc_Steps";
        String user = "root";
        String pass = "root";

        String sql = "select * from JDBC_steps.company";

        //1.Load and Register the driver
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        //2.Establish the connection
        Connection connection = DriverManager.getConnection(url, user, pass);

        //3.Create a statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next())
        {
            int anInt = resultSet.getInt(1);
            String name = resultSet.getString("name");
            double salary = resultSet.getDouble("salary");
            System.out.println(anInt+ " "+name+" "+salary);
        }

        connection.close();
        preparedStatement.close();
    }
}
