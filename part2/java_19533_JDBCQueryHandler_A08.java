import java.sql.*;

public class java_19533_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String createTableQuery = "CREATE TABLE Users (" +
                    "ID INT PRIMARY KEY," +
                    "Username VARCHAR(50)," +
                    "Password VARCHAR(50))";
            String insertDataQuery = "INSERT INTO Users (ID, Username, Password) VALUES (1, 'John', 'password123')";

            try (Statement createTableStmt = connection.createStatement()) {
                createTableStmt.executeUpdate(createTableQuery);
            }

            try (Statement insertDataStmt = connection.createStatement()) {
                insertDataStmt.executeUpdate(insertDataQuery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}