import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_09253_SessionManager_A03 {
    private static SessionManager instance;

    private java_09253_SessionManager_A03() {
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
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost/testdb", "username", "password");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}