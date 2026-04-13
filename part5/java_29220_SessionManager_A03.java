import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_29220_SessionManager_A03 {
    private static SessionManager instance;
    private Connection connection;

    private java_29220_SessionManager_A03(String dbUrl, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance(String dbUrl, String username, String password) {
        if (instance == null) {
            instance = new SessionManager(dbUrl, username, password);
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}