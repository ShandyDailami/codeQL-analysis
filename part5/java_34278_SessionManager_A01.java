import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34278_SessionManager_A01 {
    private static SessionManager instance;
    private Connection connection;

    private java_34278_SessionManager_A01(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance(String url, String username, String password) {
        if (instance == null) {
            instance = new SessionManager(url, username, password);
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}