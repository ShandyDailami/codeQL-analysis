import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_20482_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed, error: " + e.getMessage());
        }
    }
}