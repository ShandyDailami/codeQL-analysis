import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_12748_SessionManager_A08 {
    private static SessionManager instance;
    private Connection connection;

    private java_12748_SessionManager_A08(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public static SessionManager getInstance(String url, String username, String password) throws SQLException {
        if (instance == null) {
            instance = new SessionManager(url, username, password);
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }
}