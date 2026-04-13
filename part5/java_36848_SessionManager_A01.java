import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_36848_SessionManager_A01 {
    private static SessionManager instance;
    private Connection connection;

    private java_36848_SessionManager_A01() {
        String url = "jdbc:mysql://localhost:3306/db";
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
        return connection;
    }
}