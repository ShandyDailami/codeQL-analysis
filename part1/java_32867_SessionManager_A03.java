import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_32867_SessionManager_A03 {
    private static SessionManager instance;

    private java_32867_SessionManager_A03() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection;

    public void openConnection(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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