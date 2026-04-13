import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_27130_SessionManager_A08 {
    private static SessionManager instance;
    private Connection connection;

    private java_27130_SessionManager_A08() {
        // Private constructor to prevent instantiation from other classes
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
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
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
            connection = null;
        }
    }
}