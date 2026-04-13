import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34579_SessionManager_A03 {
    private static SessionManager instance = null;
    private Connection connection = null;

    private java_34579_SessionManager_A03() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/test", "username", "password");
        } catch (SQLException e) {
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
        return connection;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}