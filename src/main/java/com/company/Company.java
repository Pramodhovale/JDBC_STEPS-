package com.company;

import java.sql.*;
import java.util.Scanner;

public class Company
{
    public static void main(String[] args) throws Exception {
        Scanner  sc = new Scanner(System.in);

        String url="jdbc:mysql://localhost:3306/JDBC_Steps";
        String user = "root";
        String pass = "root";

        // Load and Register the Driver
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        // Establish the connection
        Connection connection = DriverManager.getConnection(url,user,pass);

        while (true) {
            System.out.println("============================");
            System.out.println("||   JDBC-PROJECT         ||");
            System.out.println("============================");

            System.out.println("1.Create Or Insert the Records");
            System.out.println("2.Retrieve or Fetch the Records");
            System.out.println("3.Update the Records");
            System.out.println("4.Delete or Remove the Records");
            System.out.println("5.Exit");

            System.out.println("Select the option");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Insertmethod(connection, sc);
                    break;

                case 2:
                    ReadMethod(connection);
                    break;

                case 3:
                    UpdateMethod(connection, sc);
                    break;

                case 4:
                    DeleteMethod(connection, sc);
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please enter the valid name");
            }
        }
    }

    private static void DeleteMethod(Connection connection,Scanner sc) throws SQLException {
        String sql = "Delete from JDBC_steps.company where id =?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("Enter the row number to delete:");
        int id = sc.nextInt();

        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        System.out.println("Records are deleted");
    }

    private static void UpdateMethod(Connection connection, Scanner sc) throws Exception{
        String sql="UPDATE company SET name = ?, salary = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("Enter the id");
        int id = sc.nextInt();

        System.out.println("Enter the name to change");
        String name= sc.next();

        System.out.println("Enter the salary");
        double sal = sc.nextDouble();

        preparedStatement.setString(1,name);
        preparedStatement.setDouble(2,sal);
        preparedStatement.setInt(3,id);

        int receordsupdate = preparedStatement.executeUpdate();

        if(receordsupdate>0)
            System.out.println("Records are updated");
        else
            System.out.println("Records are not updated");
    }

    private static void ReadMethod(Connection connection) throws SQLException {
        String sql = "Select * from JDBC_Steps.company";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next())
        {
            int id = rs.getInt(1);
            String name = rs.getString("name");
            double sal = rs.getDouble("salary");

            System.out.println(id + " "+name+" "+sal);
        }
    }

    private static void Insertmethod(Connection connection, Scanner sc) throws SQLException {
        String sql = "Insert into company(id,name,salary) values(?,?,?);";

        PreparedStatement ps = connection.prepareStatement(sql);

        System.out.println("Enter the id:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline

        System.out.println("Enter the name:");
        String name=sc.nextLine();

        System.out.println("Enter the salary:");
        double salary=sc.nextDouble();

        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setDouble(3,salary);
        try {
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("record inserted successfully");
        }
        catch (Exception e) {
            System.out.println("record already inserted plz try different id");
        }
    }
}
