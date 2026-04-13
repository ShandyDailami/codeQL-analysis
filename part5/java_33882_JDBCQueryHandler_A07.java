import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_33882_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            if (conn != null) {
                System.out.println("Successfully connected to database");
                // Insert, update, delete, and select operations here
            } else {
                System.out.println("Failed to connect to database");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to database: " + e.getMessage());
        }
    }
}