import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_13379_SessionManager_A01 {
    private static SessionManager instance = null;
    private Connection connection = null;

    private java_13379_SessionManager_A01() {
        // Setup connection
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            connection = DriverManager.getConnection(url, username, password);
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
        return this.connection;
    }
}