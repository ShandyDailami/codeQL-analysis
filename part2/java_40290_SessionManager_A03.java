import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_40290_SessionManager_A03 {

    private static SessionManager instance;
    private static String DB_URL;
    private static String USERNAME;
    private static String PASSWORD;

    private java_40290_SessionManager_A03() {
        // Load properties file
        // DB_URL, USERNAME, PASSWORD can be loaded from properties file
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
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
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