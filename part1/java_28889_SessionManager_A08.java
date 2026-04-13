import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_28889_SessionManager_A08 {
    private static SessionManager sessionManager = null;
    private Connection connection = null;

    private java_28889_SessionManager_A08(String dbURL, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            connection = DriverManager.getConnection(dbURL, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance(String dbURL, String user, String password) {
        if (sessionManager == null) {
            sessionManager = new SessionManager(dbURL, user, password);
        }
        return sessionManager;
    }

    public Connection getConnection() {
        if (connection != null && !connection.isClosed()) {
            return connection;
        } else {
            throw new RuntimeException("Session has expired, creating a new connection");
        }
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