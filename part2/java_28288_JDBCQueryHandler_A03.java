import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_28288_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establish the connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase", "username", "password")) {

            // Perform security-sensitive operations
            String query = "SELECT * FROM users WHERE username = ?";
            connection.prepareStatement(query).setString(1, "admin");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}