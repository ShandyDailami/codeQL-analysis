import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_06541_SessionManager_A07 {

    private static SessionManager instance;

    private java_06541_SessionManager_A07() {
        // Private constructor to prevent instantiation from outside
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection;

    public void connectToDB(String dbUrl, String user, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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