import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_35903_SessionManager_A01 {
    private static SessionManager instance;
    private Connection connection;

    private java_35903_SessionManager_A01(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance(String url, String user, String password) {
        if (instance == null) {
            instance = new SessionManager(url, user, password);
        }
        return instance;
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