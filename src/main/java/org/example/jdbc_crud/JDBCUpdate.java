package org.example.jdbc_crud;

import org.example.entity.Stuff;

import java.sql.*;
import java.util.Scanner;

public class JDBCUpdate {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        Connection connection;
        Stuff employee = new Stuff("Vova", 5);

        try{
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name:");
            String enteredName = scanner.nextLine();

            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE stuff SET officeId = 2 WHERE name = ?");
            statement.setString(1, employee.getName());
            statement.executeUpdate();

            connection.close();
            if(connection.isClosed() ) {
                System.out.println("Соединение с БД закрыто");
            }
        }
        catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }

    }

}
