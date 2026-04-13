import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11894_SessionManager_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Connection connection = sessionManager.getConnection();
        if (connection != null) {
            System.out.println("Connection successful.");
            sessionManager.closeConnection(connection);
        } else {
            System.out.println("Connection failed.");
        }
    }
}