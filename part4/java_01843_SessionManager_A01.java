import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01843_SessionManager_A01 {
    private static SessionManager instance;
    private Connection connection;

    private java_01843_SessionManager_A01(String url, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions as needed (e.g., log, throw, recover)
        }
    }

    public static SessionManager getInstance(String url, String username, String password) {
        if (instance == null) {
            instance = new SessionManager(url, username, password);
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}