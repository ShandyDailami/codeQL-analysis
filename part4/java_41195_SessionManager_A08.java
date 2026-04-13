import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class java_41195_SessionManager_A08 {
    // Connection pool parameters
    private static final int MAX_POOL_SIZE = 10;
    private static final int CONNECTION_TIMEOUT = 60;

    // Session queue
    private BlockingQueue<Connection> connectionQueue;

    // Constructor
    public java_41195_SessionManager_A08() {
        this.connectionQueue = new ArrayBlockingQueue<>(MAX_POOL_SIZE, true);
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create the connection pool
            for (int i = 0; i < MAX_POOL_SIZE; i++) {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password",
                        java.sql.DriverManager.defaultConnectionPoolSize);
                connectionQueue.put(conn);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to get a connection from the pool
    public Connection getConnection() throws InterruptedException {
        return connectionQueue.take();
    }

    // Method to return a connection back to the pool
    public void returnConnection(Connection conn) {
        if (conn != null) {
            connectionQueue.put(conn);
        }
    }
}