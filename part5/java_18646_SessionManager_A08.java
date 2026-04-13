import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_18646_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
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
        LegacySessionManager sessionManager = new LegacySessionManager();

        try (Connection conn = sessionManager.getConnection()) {
            // Perform operations here
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}