import java.security.Permission;
import java.security.SecurityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class java_17797_JDBCQueryHandler_A08 {

    // Create a security manager to handle the user creation
    private SecurityManager sm = new SecurityManager() {
        @Override
        public void checkPermission(Permission perm) {
            if (perm.getName().contains("createUser")) {
                throw new SecurityException("Create user permission denied by security manager");
            }
        }
    };

    public Connection getConnection(String url, String user, String password) throws SQLException {
        // Use the custom security manager to create the connection
        sm.checkPermission(new RuntimePermission("createConnection"));
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        try {
            Connection conn = handler.getConnection("jdbc:mysql://localhost:3306/test", "test", "test");
            System.out.println("Connected successfully!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
        }
    }
}