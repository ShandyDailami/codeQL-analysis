import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_19629_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Establish connection with database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "username", "password")) {

            // Test connection
            if (connection != null) {
                System.out.println("Connected to database");
            } else {
                System.out.println("Failed to connect to database");
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}