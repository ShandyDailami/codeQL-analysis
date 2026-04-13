import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class java_17321_SessionManager_A08 {
    private Queue<Connection> pool;
    private String url;
    private String username;
    private String password;

    private static final int POOL_SIZE = 10;

    public java_17321_SessionManager_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.pool = new LinkedList<>();

        for(int i = 0; i < POOL_SIZE; i++) {
            try {
                this.pool.add(DriverManager.getConnection(url, username, password));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return pool.poll();
    }

    public void returnConnection(Connection connection) {
        if(connection != null) {
            pool.add(connection);
        }
    }
}