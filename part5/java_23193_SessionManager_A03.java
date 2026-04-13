import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23193_SessionManager_A03 {
    private static SessionManager instance;
    private Connection connection;

    private java_23193_SessionManager_A03() {
        // Private constructor to prevent instantiation of the class
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        if (connection == null || connection.isClosed()) {
            try {
                // Here, you should use a real URL, username, and password.
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}