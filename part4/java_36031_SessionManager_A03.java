import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_36031_SessionManager_A03 {
    private static SessionManager sessionManager;
    private Connection connection;

    private java_36031_SessionManager_A03(String dbURL, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public static SessionManager getInstance(String dbURL, String user, String password) throws SQLException {
        if (sessionManager == null) {
            sessionManager = new SessionManager(dbURL, user, password);
        }
        return sessionManager;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}