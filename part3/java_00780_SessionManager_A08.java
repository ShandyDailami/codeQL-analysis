import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_00780_SessionManager_A08 {

    private static SessionManager instance;

    private java_00780_SessionManager_A08() {
        // private constructor to prevent instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection;

    public void openConnection(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}