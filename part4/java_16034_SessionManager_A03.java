import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_16034_SessionManager_A03 {
    private static SessionManager instance;

    private java_16034_SessionManager_A03() {
        // Private constructor to prevent instantiation from outside
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection(String url, String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Handle the exception appropriately (e.g., log it or ignore it)
            }
        }
    }
}