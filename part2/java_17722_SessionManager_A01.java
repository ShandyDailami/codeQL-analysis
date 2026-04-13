import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_17722_SessionManager_A01 {
    private static SessionManager instance = null;
    private Connection connection = null;

    private java_17722_SessionManager_A01() {
        try {
            // This is a placeholder and should be replaced with your actual database connection details
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
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
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}