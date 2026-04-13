import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_08089_SessionManager_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static SessionManager instance;
    private Connection connection;

    private java_08089_SessionManager_A01() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
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
                instance = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            SessionManager sessionManager = SessionManager.getInstance();
            Connection connection = sessionManager.getConnection();
            // Perform operations with the connection...
            sessionManager.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}