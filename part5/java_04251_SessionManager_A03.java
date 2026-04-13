import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_04251_SessionManager_A03 {

    private static SessionManager instance;
    private Connection connection;

    private java_04251_SessionManager_A03(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public static SessionManager getInstance(String url, String user, String password) throws SQLException {
        if (instance == null) {
            instance = new SessionManager(url, user, password);
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}