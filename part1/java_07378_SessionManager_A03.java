import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_07378_SessionManager_A03 {

    private static final String url = "jdbc:mysql://localhost:3306/bookstore";
    private static final String username = "root";
    private static final String password = "password";

    private java_07378_SessionManager_A03() {}

    private static class SessionManagerHolder {
        private static final SessionManager INSTANCE = new SessionManager();
    }

    public static SessionManager getInstance() {
        return SessionManagerHolder.INSTANCE;
    }

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}