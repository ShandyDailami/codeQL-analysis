import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_12808_SessionManager_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Connection connection = null;
        try {
            connection = sessionManager.getConnection();
            // perform operations using the connection
            // ...
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                sessionManager.closeConnection(connection);
            }
        }
    }
}