import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_13485_SessionManager_A01 {
    private static SessionManager instance = null;
    private Connection connection = null;

    // Private constructor to prevent instantiation
    private java_13485_SessionManager_A01() {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            connection = DriverManager.getConnection(url, username, password);
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

    public Connection getConnection() {
        return connection;
    }
}