import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class java_35915_SessionManager_A03 {
    private final String url;
    private final String username;
    private final String password;
    private final Queue<Connection> pool;
    private final int POOL_SIZE;

    public java_35915_SessionManager_A03(String url, String username, String password, int poolSize) {
        this.url = url;
        this.username = username;
        this.password = password;
        POOL_SIZE = poolSize;
        pool = new LinkedList<>();

        for (int i = 0; i < POOL_SIZE; i++) {
            pool.add(createConnection());
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        Connection connection = pool.poll();
        if (connection == null) {
            connection = createConnection();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            pool.add(connection);
        }
    }
}