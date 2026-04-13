import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_24660_SessionManager_A03 {

    private static SessionManager instance;
    private Connection connection;

    private java_24660_SessionManager_A03(String url, String user, String password) throws SQLException {
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

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}