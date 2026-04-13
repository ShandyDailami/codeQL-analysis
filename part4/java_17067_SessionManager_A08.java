import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_17067_SessionManager_A08 {
    private static SessionManager instance = null;

    private java_17067_SessionManager_A08() {
        // private constructor to prevent instantiation from outside
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection = null;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}