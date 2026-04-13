import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_21465_SessionManager_A03 {
    private static SessionManager instance;
    private Connection connection;

    private java_21465_SessionManager_A03() {
        // Load the driver. Replace with actual driver if necessary
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
                connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "username", "password");
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
        connection = null;
    }
}