import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_37095_SessionManager_A03 {

    // Driver and URL for MySQL database
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // Constructor
    public java_37095_SessionManager_A03() {
        // Load the MySQL driver
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle or log error
        }
    }

    // Method to obtain database connection
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or log error
        }
        return conn;
    }

    // Method to close the database connection
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle or log error
            }
        }
    }

    // Test method
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Connection conn = sessionManager.getConnection();
        // ... perform database operations
        sessionManager.closeConnection(conn);
    }
}