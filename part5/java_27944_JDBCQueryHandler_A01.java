import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_27944_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Establish the connection to the database
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            // Example of a security-sensitive operation
            String selectQuery = "SELECT * FROM users";
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(selectQuery);
                while (rs.next()) {
                    System.out.println("User: " + rs.getString("username"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}