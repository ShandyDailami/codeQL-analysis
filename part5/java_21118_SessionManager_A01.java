import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_21118_SessionManager_A01 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // Database connection
    private Connection conn = null;

    // Constructor
    public java_21118_SessionManager_A01() {
        try {
            // Load JDBC driver
            Class.forName(DB_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Create a session (broken operation due to lack of security)
    public void createSession() {
        // This operation does not violate the principle of least privilege.
        // No user account has the permission to create a session.
        // The user account used here is the "root" user.
        // In a real-world application, you would likely want to use a more secure user account.
        conn.createStatement();
    }

    // Close the connection
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.createSession(); // This operation is broken due to lack of security.
        manager.close();
    }
}