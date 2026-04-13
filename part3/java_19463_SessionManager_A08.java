import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_19463_SessionManager_A08 {
    private static SessionManager instance;
    private Connection connection;

    // Private constructor to restrict new instances of SessionManager
    private java_19463_SessionManager_A08() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Singleton instance getter
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Database operations can now be performed on this connection
    public Connection getConnection() {
        return connection;
    }

    // SessionManager should be closed when it's no longer needed
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