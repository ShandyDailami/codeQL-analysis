import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_26354_SessionManager_A01 {
    private static SessionManager instance;
    private Connection connection;

    private java_26354_SessionManager_A01(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public static SessionManager getInstance(String url, String user, String password) throws SQLException {
        if (instance == null) {
            instance = new SessionManager(url, user, password);
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        SessionManager sessionManager = SessionManager.getInstance("jdbc:mysql://localhost:3306/test", "root", "password");
        Connection connection = sessionManager.getConnection();
        // perform security-sensitive operations here
        connection.close();
    }
}