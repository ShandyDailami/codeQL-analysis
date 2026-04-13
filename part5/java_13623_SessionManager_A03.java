import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_13623_SessionManager_A03 {
    private static SessionManager instance = null;

    private java_13623_SessionManager_A03() {
        // Private constructor to prevent instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        return DriverManager.getConnection(url, username, password);
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

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        Connection conn = sm.getConnection();

        // Protected resource management
        sm.closeConnection(conn);
    }
}