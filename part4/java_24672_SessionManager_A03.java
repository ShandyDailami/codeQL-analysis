import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_24672_SessionManager_A03 {

    private static SessionManager instance = null;

    private java_24672_SessionManager_A03() {
        // Prevent instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection = null;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/mydb";
            String username = "root";
            String password = "password";
            connection = DriverManager.getConnection(url, username, password);
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
        try {
            SessionManager sm = SessionManager.getInstance();
            Connection conn = sm.getConnection();
            // perform operations here
            sm.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}