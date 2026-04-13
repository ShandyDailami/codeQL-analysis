import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01637_SessionManager_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Connection conn = null;

        try {
            conn = sessionManager.getConnection();

            // Security-sensitive operations here
            // For example, executing SQL queries without a prepared statement
            conn.createStatement().execute("SELECT * FROM Users");

            sessionManager.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                sessionManager.closeConnection(conn);
            }
        }
    }
}