import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class java_35023_SessionManager_A03 {
    private static List<Connection> connectionPool = new ArrayList<>();
    private static int poolSize = 10;

    public java_35023_SessionManager_A03() {
        // Initialize the connection pool
        for (int i = 0; i < poolSize; i++) {
            Connection conn = createConnection();
            connectionPool.add(conn);
        }
    }

    private Connection createConnection() {
        // You would typically use a properties file to get the database connection details
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Connection getConnection() {
        // If the connection pool is empty, create a new connection
        if (connectionPool.isEmpty()) {
            Connection conn = createConnection();
            connectionPool.add(conn);
            return conn;
        }

        // Otherwise, get a connection from the pool
        Connection conn = connectionPool.remove(0);
        connectionPool.add(conn);
        return conn;
    }

    public void closeConnection(Connection conn) {
        connectionPool.remove(conn);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Example usage
        try {
            Connection conn = manager.getConnection();

            // ... your code here ...

            manager.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}