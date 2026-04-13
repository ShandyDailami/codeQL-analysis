import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_27151_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final int POOL_SIZE = 10;

    private BlockingQueue<Connection> connections = new LinkedBlockingQueue<>(POOL_SIZE);

    public java_27151_JDBCQueryHandler_A08() {
        try {
            Class.forName(DRIVER);
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                connections.put(conn);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Error initializing database connection pool: " + e.getMessage());
        }
    }

    public Connection getConnection() throws InterruptedException, SQLException {
        return connections.take();
    }

    public void releaseConnection(Connection conn) {
        if (conn != null) {
            connections.put(conn);
        }
    }
}