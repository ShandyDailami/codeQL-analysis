import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class java_35675_SessionManager_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final int POOL_SIZE = 10;

    private BlockingDeque<Connection> connectionPool;

    public java_35675_SessionManager_A08() {
        connectionPool = new LinkedBlockingDeque<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                connectionPool.add(conn);
            } catch (SQLException e) {
                System.out.println("Error occurred while creating connection: " + e.getMessage());
                // Handle exception...
            }
        }
    }

    public Connection getConnection() throws InterruptedException {
        return connectionPool.take();
    }

    public void returnConnection(Connection conn) {
        connectionPool.add(conn);
    }
}