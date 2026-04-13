import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_18555_SessionManager_A03 {

    private static CustomSessionManager instance;
    private Connection connection;

    private java_18555_SessionManager_A03(String dbURL, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Error while initializing the database connection.", e);
        }
    }

    public static CustomSessionManager getInstance(String dbURL, String user, String password) {
        if (instance == null) {
            instance = new CustomSessionManager(dbURL, user, password);
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}