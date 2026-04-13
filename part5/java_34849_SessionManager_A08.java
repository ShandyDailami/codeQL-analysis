import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34849_SessionManager_A08 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Create a new connection
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Close the connection
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Main method to test the code
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        Connection conn = sm.getConnection();

        // Perform integrity-sensitive operations here...

        sm.closeConnection(conn);
    }
}