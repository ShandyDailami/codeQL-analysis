import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17199_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Users WHERE username = ?";
            try (Statement statement = connection.createStatement()) {
                String user = "user";
                ResultSet resultSet = statement.executeQuery(query, user);
                if (resultSet.next()) {
                    // perform integrity failure related operations
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}