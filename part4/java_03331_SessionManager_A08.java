import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_03331_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public void openSession() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void closeSession() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        try {
            sessionManager.openSession();
            // Do something with the session
            sessionManager.closeSession();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}