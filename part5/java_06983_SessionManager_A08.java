import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_06983_SessionManager_A08 {

    private static SessionManager instance;

    private java_06983_SessionManager_A08() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection;

    public Connection getConnection() {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}