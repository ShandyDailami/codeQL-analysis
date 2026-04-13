import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_30890_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static SessionManager sessionManager;

    private java_30890_SessionManager_A03() {
        // private constructor to prevent instantiation from outside
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        Connection connection = null;
        try {
            connection = sm.getConnection();
            // perform operations on the connection here
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sm.closeConnection(connection);
        }
    }
}