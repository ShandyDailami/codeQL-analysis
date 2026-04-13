import java.sql.*;
import java.util.Properties;

public class java_13604_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Connect to the database
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "password");
        props.setProperty("useSSL", "false");
        props.setProperty("serverTimezone", "UTC");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", props)) {
            // Check if user is authorized
            String username = "admin";
            String query = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("User is authorized.");
                        // Continue the access if user is authorized
                        // Access the database as user
                    } else {
                        System.out.println("User is not authorized.");
                        // Stop the access if user is not authorized
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}