import java.sql.*;
import java.util.Properties;

public class java_28240_JDBCQueryHandler_A08 {
    private static final String ALLOWED_IP = "127.0.0.1"; // Only allow connections from this IP address

    public static void main(String[] args) {
        executeQuery("SELECT * FROM Users WHERE Email = ?");
    }

    public static void executeQuery(String query) {
        Properties props = new Properties();
        props.setProperty("user", "user");
        props.setProperty("password", "password");
        props.setProperty("useSSL", "false");
        props.setProperty("serverTimezone", "UTC");

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", props)) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        // Process the result set
                        System.out.println(rs.getString("Email"));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}