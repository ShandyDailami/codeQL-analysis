import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_42092_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final int POOL_SIZE = 10;
    private static BlockingQueue<Connection> pool;

    static {
        pool = new LinkedBlockingQueue<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                pool.put(DriverManager.getConnection(URL, USER, PASSWORD));
            } catch (SQLException | InterruptedException e) {
                throw new ExceptionInInitializerError("Error in initializing database connection pool");
            }
        }
    }

    private java_42092_SessionManager_A03() {}

    public static Connection getConnection() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            throw new RuntimeException("Error in session pool", e);
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            pool.put(connection);
        }
    }
}