import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_22527_SessionManager_A08 {
    private static String url = "jdbc:mysql://localhost:3306/db_name";
    private static String username = "username";
    private static String password = "password";

    private static SessionManager instance;
    private Connection connection;

    private java_22527_SessionManager_A08() {
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
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}