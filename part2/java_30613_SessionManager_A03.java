import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_30613_SessionManager_A03 {
    // The database credentials
    private static final String DB_USERNAME = "user";
    private static final String DB_PASSWORD = "password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    // The connection pool
    private static ConnectionPool connectionPool;

    // SecurityManager instance
    private SecurityManager securityManager;

    public java_30613_SessionManager_A03() {
        // Create a new ConnectionPool
        connectionPool = new ConnectionPool(DB_URL, DB_USERNAME, DB_PASSWORD);

        // Create a new SecurityManager
        securityManager = new SecurityManager() {
            @Override
            public boolean checkUser(String s) throws SQLException {
                // The checkUser method checks if the given string is a valid user.
                // In this case, we only allow users "user" and "admin".
                return s.equals("user") || s.equals("admin");
            }
        };
    }

    // Method to get a connection from the ConnectionPool
    public Connection getConnection() throws SQLException {
        // The ConnectionPool will take care of the connection pooling
        return connectionPool.getConnection();
    }

    // Method to close a connection back to the ConnectionPool
    public void closeConnection(Connection c) {
        connectionPool.closeConnection(c);
    }

    public static void main(String[] args) {
        // Create a new SessionManager
        SessionManager sessionManager = new SessionManager();

        // Open a connection
        Connection c;
        try {
            c = sessionManager.getConnection();

            // Do some secure operations
            c.createStatement().execute("insert into Users(username, password) values ('user', 'password')");

            // Close the connection
            sessionManager.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}