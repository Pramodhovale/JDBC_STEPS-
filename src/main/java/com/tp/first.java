package com.tp;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class first {
    public static void main(String[] args) throws SQLException {

        // 1. Load and register the driver
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        // 2. Establish connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_steps",
                "root",
                "root"
        );

        // 3. Create statement
        Statement statement = connection.createStatement();

        // 4. Execute INSERT query
        int rowsInserted = statement.executeUpdate(
                "INSERT INTO player VALUES (23, 'kano', 100)"
        );

        if (rowsInserted > 0) {
            System.out.println("Row inserted successfully into player table");
        } else {
            System.out.println("Failed to insert data");
        }

        // 5. Close resources
        statement.close();
        connection.close();
    }
}