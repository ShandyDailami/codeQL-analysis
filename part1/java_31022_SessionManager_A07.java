import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_31022_SessionManager_A07 {
    private static SessionManager instance;
    private Connection connection;

    private java_31022_SessionManager_A07(String dbUrl, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public static SessionManager getInstance(String dbUrl, String user, String password) {
        if (instance == null) {
            instance = new SessionManager(dbUrl, user, password);
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}