import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23324_SessionManager_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
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

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();
        Connection conn = sessionManager.getConnection();
        if (conn != null) {
            // perform secure sensitive operations here
            sessionManager.closeConnection(conn);
        }
    }
}