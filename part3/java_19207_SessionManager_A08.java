import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class java_19207_SessionManager_A08 {
    private final BlockingQueue<Connection> queue;
    private final String url;

    public java_19207_SessionManager_A08(String url, int size) {
        this.url = url;
        queue = new ArrayBlockingQueue<>(size);
        for (int i = 0; i < size; i++) {
            try {
                queue.put(DriverManager.getConnection(url));
            } catch (SQLException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Connection getConnection() {
        Connection connection;
        try {
            connection = queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void returnConnection(Connection connection) {
        if (connection != null) {
            queue.put(connection);
        }
    }

    public void closeAll() {
        try {
            queue.put(null);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}