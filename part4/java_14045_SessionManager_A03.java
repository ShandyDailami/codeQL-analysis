import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_14045_SessionManager_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";
    private static SessionManager instance;

    private java_14045_SessionManager_A03() {
        // Private constructor to restrict instantiation of class
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null && connection.isClosed()) {
            connection.close();
        }
    }
}