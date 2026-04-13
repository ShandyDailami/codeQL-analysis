import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_31301_SessionManager_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Connection connection = sessionManager.getConnection();

        // Perform operations with the connection...

        sessionManager.closeConnection(connection);
    }
}