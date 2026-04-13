import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_29574_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Basic access control
        // Let's assume the current user is "user"
        String currentUser = "user";

        // Create a security manager
        java.security.SecurityManager securityManager = new java.security.SecurityManager() {
            public void checkPermission(java.security.Permission perm) {
                if (perm instanceof java.net.SocketPermission) {
                    throw new java.lang.SecurityException("Broken Access Control");
                }
            }
        };
        System.setSecurityManager(securityManager);

        // Establish a connection
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user", "password")) {
            // Create a statement
            try (Statement stmt = conn.createStatement()) {
                // Execute the query
                ResultSet rs = stmt.executeQuery("SELECT * FROM users");

                while (rs.next()) {
                    System.out.println("User: " + rs.getString("username"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in JDBC connection: " + ex.getMessage());
        }
    }
}