import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_38969_SessionManager_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        try {
            SessionManager sessionManager = new SessionManager();
            Connection connection = sessionManager.getConnection();

            // Perform security-sensitive operations here

            sessionManager.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}