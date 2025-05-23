package org.example.jdbc_crud;

import org.example.entity.Stuff;

import java.sql.*;
import java.util.Scanner;

public class JDBCSelect {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        Connection connection;

        try{
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter OfficeID:");
            Integer enteredOfficeID = Integer.parseInt(scanner.nextLine());

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM stuff WHERE officeID = ?"); // выбираем из таблицы всех сотрудников по officeID
            statement.setInt(1, enteredOfficeID);
            ResultSet resultSet = statement.executeQuery(); // помещаем их в ResultSet

                        while (resultSet.next()){
                Stuff resEmployee = new Stuff();
                resEmployee.setId(resultSet.getLong("id")); // из ResultSet достаём все данные сотрудника, включая автоинициализируемое id
                resEmployee.setName(resultSet.getString("name"));
                resEmployee.setOfficeID(resultSet.getInt("officeID"));
                System.out.println("id: " + resEmployee.getId() + ", name: " + resEmployee.getName() + ", officeID: " + resEmployee.getOfficeID());
            }

            statement.close();
            resultSet.close();
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
