import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_32691_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";
    private static final int MAX_POOL_SIZE = 10;

    private BlockingQueue<Connection> connectionPool;

    public java_32691_JDBCQueryHandler_A01() {
        connectionPool = new LinkedBlockingQueue<>(MAX_POOL_SIZE);

        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            try {
                connectionPool.put(DriverManager.getConnection(URL, USER, PASS));
            } catch (SQLException e) {
                throw new ExceptionInInitializerError("Failed to initialize connection pool");
            }
        }
    }

    public Connection getConnection() throws InterruptedException {
        return connectionPool.take();
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            connectionPool.put(connection);
        }
    }
}