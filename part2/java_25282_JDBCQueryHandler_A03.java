import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_25282_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database");

            // Create a new user
            String createUserQuery = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            connection.prepareStatement(createUserQuery).executeUpdate();

            // Retrieve a user
            String selectUserQuery = "SELECT * FROM users WHERE id = ?";
            try (java.sql.PreparedStatement selectStatement = connection.prepareStatement(selectUserQuery)) {
                selectStatement.setInt(1, 1);
                java.sql.ResultSet resultSet = selectStatement.executeQuery();
                if (resultSet.next()) {
                    System.out.println("User found: " + resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}