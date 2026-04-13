import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_31981_SessionManager_A08 {
    private static SessionManager instance;

    private java_31981_SessionManager_A08() {
        // Private constructor to prevent instantiation from other classes
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection;

    public void openConnection(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}