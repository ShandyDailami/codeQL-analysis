import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_04029_SessionManager_A03 {

    // The database URL and credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    // Method to establish a secure connection
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        return conn;
    }

    // Example of a secure operation
    public void secureOperation(Connection conn) {
        if (conn != null) {
            try {
                // Perform a secure operation
                conn.createStatement().execute("SELECT * FROM Users");
                System.out.println("Operation successful");
            } catch (SQLException e) {
                System.out.println("Failed to perform operation");
                e.printStackTrace();
            }
        } else {
            System.out.println("Connection is null");
        }
    }

    // Main method to test the program
    public static void main(String[] args) {
        SecureSessionManager manager = new SecureSessionManager();
        Connection conn = manager.getConnection();
        manager.secureOperation(conn);
    }
}