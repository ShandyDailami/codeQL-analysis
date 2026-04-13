import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_08040_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM users WHERE username = ?";
            connection.prepareStatement(query).executeUpdate(username);
            System.out.println("Access granted for user: " + username);
        } catch (SQLException e) {
            System.out.println("Failed to access database: " + e.getMessage());
        }
    }
}