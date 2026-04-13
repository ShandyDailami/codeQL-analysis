import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01548_SessionManager_A08 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        Connection conn = null;
        try {
            conn = sm.getConnection();
            // perform your operations here
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sm.closeConnection(conn);
        }
    }
}