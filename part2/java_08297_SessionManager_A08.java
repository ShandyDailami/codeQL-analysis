import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_08297_SessionManager_A08 {
    private static SessionManager instance;

    private java_08297_SessionManager_A08() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        try {
            sm.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}