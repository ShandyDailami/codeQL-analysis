import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12025_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            // Step 2: Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE role = 'admin'");

            // Step 3: Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");
                System.out.println("Name: " + name);
                System.out.println("Role: " + role);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}