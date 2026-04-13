import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_06405_SessionManager_A03 {

    private static SessionManager sessionManager;
    private Connection connection;

    private java_06405_SessionManager_A03(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public static SessionManager getInstance(String url, String username, String password) throws SQLException {
        if (sessionManager == null) {
            sessionManager = new SessionManager(url, username, password);
        }
        return sessionManager;
    }

    public Connection getConnection() {
        return this.connection;
    }
}