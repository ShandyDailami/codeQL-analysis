import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_05087_SessionManager_A08 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Create a connection to the database
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Main method for testing
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        Connection conn = sm.getConnection();
        // Use the connection to perform operations
        // ...
    }
}