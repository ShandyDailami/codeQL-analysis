import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_00944_SessionManager_A03 {
    private static SessionManager instance;

    private java_00944_SessionManager_A03() {
        // Private constructor to prevent instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}