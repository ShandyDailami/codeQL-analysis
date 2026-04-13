import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_30971_SessionManager_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static SessionManager instance;

    private java_30971_SessionManager_A08() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
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

    public static void main(String[] args) {
        SessionManager sessionManager = SessionManager.getInstance();
        Connection conn = sessionManager.getConnection();

        // Here you can put your code to handle sessions

        sessionManager.closeConnection(conn);
    }
}