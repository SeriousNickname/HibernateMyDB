package org.example.jdbc_crud;

import org.example.entity.Stuff;

import java.sql.*;

public class JDBCInsert {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        Connection connection;
        Stuff employee = new Stuff("Vlad", 5L);

        try{
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO stuff (name, officeID) VALUES (?, ?)"
            , Statement.RETURN_GENERATED_KEYS); // получаем генерируемое таблицей ключи
            statement.setString(1, employee.getName());
            statement.setLong(2, employee.getOfficeID());

            int affectedRows = statement.executeUpdate();
            if(affectedRows == 0) {
                throw new SQLException("не получилось добавить студента в БД");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                employee.setId(generatedKeys.getLong(1));
            }
            else {
                throw new SQLException("не получилось создать id студента");
            }


            System.out.println(employee);

            statement.close();
            generatedKeys.close();

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
