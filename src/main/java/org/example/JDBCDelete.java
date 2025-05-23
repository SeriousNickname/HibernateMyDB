package org.example;

import java.sql.*;
import java.util.Scanner;

public class JDBCDelete { private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        Connection connection;

        try{
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Name:");
            String enteredName = scanner.nextLine();

            try (PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM stuff WHERE name = ?")) {    // удаляем сотрудника по имени
                statement.setString(1, enteredName);
                int deletedRows = statement.executeUpdate();
                System.out.println("Deleted empolyees: " + deletedRows);
            }

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
