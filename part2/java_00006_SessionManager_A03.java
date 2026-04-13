import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_00006_SessionManager_A03 {

    private static SessionManager instance = null;

    private java_00006_SessionManager_A03() {
        // Load driver only if it's not already loaded
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("MySQL JDBC Driver not found");
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC",
                    "username",
                    "password");

            // Adding security measures, e.g. connection pooling, statement caching, etc.
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}