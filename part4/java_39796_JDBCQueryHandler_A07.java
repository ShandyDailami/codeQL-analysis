import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_39796_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "testuser");
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    System.out.println("User found: " + result.getString("username"));
                }
            }

            // Authentication failure handling
            String queryAuthFailure = "SELECT * FROM failed_logins WHERE ip_address = ?";
            try (PreparedStatement statementAuthFailure = connection.prepareStatement(queryAuthFailure)) {
                statementAuthFailure.setString(1, "127.0.0.1");
                ResultSet resultAuthFailure = statementAuthFailure.executeQuery();
                if (resultAuthFailure.next()) {
                    System.out.println("Authentication failure found for IP address: " + resultAuthFailure.getString("ip_address"));
                } else {
                    System.out.println("No authentication failures found for IP address: " + "127.0.0.1");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}