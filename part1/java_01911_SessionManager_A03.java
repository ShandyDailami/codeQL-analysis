import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01911_SessionManager_A03 {
    private static Connection connection;

    // Connect to the database
    public static void connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        connection = DriverManager.getConnection(url, username, password);
    }

    // Return the connection
    public static Connection getConnection() {
        return connection;
    }

    // Close the connection
    public static void close() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        // Connect to the database
        connect();

        // Start a new session
        SessionManager session = new SessionManager();

        // Use the session
        // Your code here...

        // Close the connection
        close();
    }
}