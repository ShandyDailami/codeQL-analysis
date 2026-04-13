import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class java_21478_SessionManager_A03 {
    private final String url;
    private final String username;
    private final String password;

    private final Queue<Connection> connectionQueue;

    private final int poolSize;

    public java_21478_SessionManager_A03(String url, String username, String password, int poolSize) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.poolSize = poolSize;

        connectionQueue = new LinkedList<>();

        for (int i = 0; i < poolSize; i++) {
            createConnection();
        }
    }

    public Connection getConnection() throws SQLException {
        if (connectionQueue.isEmpty()) {
            createConnection();
        }

        return connectionQueue.remove();
    }

    private void createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        connectionQueue.add(connection);
    }

    public void returnConnection(Connection connection) {
        connectionQueue.add(connection);
    }
}