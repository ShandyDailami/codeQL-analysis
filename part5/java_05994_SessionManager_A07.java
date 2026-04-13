import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_05994_SessionManager_A07 {

    // URL and credentials for the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Create a connection
    private Connection connection;

    // Create a session
    private java.util.Optional<Connection> session;

    public java_05994_SessionManager_A07() {
        session = getConnection();
    }

    // Get a connection from the pool
    public java.util.Optional<Connection> getConnection() {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            }
        }

        return java.util.Optional.ofNullable(connection);
    }

    // Close a connection
    public void closeConnection(Connection connection) {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            }
        }
    }

    // Use the connection
    public void useConnection(java.util.function.Consumer<Connection> consumer) {
        session.ifPresent(consumer);
        closeConnection(connection);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.useConnection(conn -> {
            // Code here
        });
    }
}