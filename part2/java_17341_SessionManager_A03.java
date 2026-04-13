import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_17341_SessionManager_A03 {
    private static SessionManager instance = null;
    private Connection connection = null;

    // Singleton pattern
    private java_17341_SessionManager_A03() {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
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
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnectionSilent() {
        try {
            connection.close();
        } catch (SQLException e) {}
    }
}