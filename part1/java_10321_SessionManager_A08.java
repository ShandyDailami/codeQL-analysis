import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_10321_SessionManager_A08 {
    private static SecureSessionManager instance;
    private Connection connection;

    private java_10321_SessionManager_A08() {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SecureSessionManager getInstance() {
        if (instance == null) {
            instance = new SecureSessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}