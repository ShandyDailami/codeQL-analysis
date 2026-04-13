import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class java_10121_SessionManager_A08 {

    private List<Connection> pool;
    private final String url;
    private final String user;
    private final String password;
    private static final int POOL_SIZE = 10;

    public java_10121_SessionManager_A08(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.pool = new ArrayList<>();
        for (int i = 0; i < POOL_SIZE; i++) {
            this.pool.add(createConnection());
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        if (pool.isEmpty()) {
            return createConnection();
        } else {
            Connection connection = pool.remove(0);
            if (connection == null) {
                return createConnection();
            }
            return connection;
        }
    }

    public void returnConnection(Connection connection) {
        if (connection != null) {
            pool.add(connection);
        }
    }

    public void integrityFailureOperation() {
        try {
            Connection connection = getConnection();
            connection.prepareStatement("SELECT * FROM non_existent_table").execute();
            returnConnection(connection);
        } catch (Exception e) {
            System.out.println("Error in integrity failure operation: " + e.getMessage());
        }
    }
}