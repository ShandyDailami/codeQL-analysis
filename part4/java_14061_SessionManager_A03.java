import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_14061_SessionManager_A03 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Singleton instance
    private static SessionManager instance = null;

    private java_14061_SessionManager_A03() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Enable connection pooling
            conn.setAutoCommit(false);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}