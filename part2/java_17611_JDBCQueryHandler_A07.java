import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_17611_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Establish a connection
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // Update with your database URL
        String username = "myusername"; // Update with your username
        String password = "mypassword"; // Update with your password

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Step 2: Prepare the SQL query
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                // Step 3: Set parameters
                statement.setString(1, "user1"); // Change to the actual username
                statement.setString(2, "password1"); // Change to the actual password

                // Step 4: Execute the query
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed!");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}