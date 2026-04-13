import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11270_SessionManager_A03 {
    private static SessionManager instance = null;
    private Connection connection = null;

    private java_11270_SessionManager_A03() {
        // Private constructor to restrict instantiation
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
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}