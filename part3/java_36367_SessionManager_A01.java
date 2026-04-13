import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_36367_SessionManager_A01 {
    private static SessionManager instance = null;
    private Connection conn = null;

    // Private constructor to prevent instantiation
    private java_36367_SessionManager_A01() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        Connection conn = sm.getConnection();

        // Perform security-sensitive operations here

        sm.closeConnection();
    }
}