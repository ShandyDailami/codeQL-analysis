import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_39603_SessionManager_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static SessionManager sessionManager;

    private java_39603_SessionManager_A08() {
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = SessionManager.getInstance();
        Connection connection = sessionManager.getConnection();
        // perform integrity-sensitive operations with the connection here
        sessionManager.closeConnection(connection);
    }
}