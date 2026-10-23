package com.company;

import java.sql.*;

public class Delete {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc_Steps";
        String user = "root";
        String pass = "root";

        String sql ="Delete from company where id=1";

        //1.Load and Register the Driver
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        //2.Establish the connection
        Connection connection = DriverManager.getConnection(url, user, pass);

        //3.create a statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int deleted = preparedStatement.executeUpdate();

        if(deleted>0)
        {
            System.out.println("The recorde is deleted"+deleted);
        }
        else
        {
            System.out.println("The recorde is not deleted");
        }
        preparedStatement.close();
        connection.close();
    }
}
