import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_03856_SessionManager_A03 {
    private static SessionManager sessionManager;
    private Connection connection;

    private java_03856_SessionManager_A03(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance(String url, String username, String password) {
        if (sessionManager == null) {
            sessionManager = new SessionManager(url, username, password);
        }
        return sessionManager;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}