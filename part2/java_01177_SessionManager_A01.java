import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01177_SessionManager_A01 {

    private static SessionManager instance;
    private Connection connection;

    private java_01177_SessionManager_A01(String dbUrl, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionManager getInstance(String dbUrl, String username, String password) {
        if (instance == null) {
            instance = new SessionManager(dbUrl, username, password);
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
                throw new RuntimeException(e);
            }
        }
    }
}