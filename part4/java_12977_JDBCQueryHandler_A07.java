import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_12977_JDBCQueryHandler_A07 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "user";
    private static final String PASS = "password";

    private static final int MAX_POOL_SIZE = 10;

    private BlockingQueue<Connection> connectionPool;

    public java_12977_JDBCQueryHandler_A07() {
        connectionPool = new LinkedBlockingQueue<>(MAX_POOL_SIZE);

        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            try {
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                connectionPool.put(connection);
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
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

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();

        // Example: run a query
        try (Connection connection = queryHandler.getConnection()) {
            String sql = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        }

        queryHandler.releaseConnection(connection); // Remember to release the connection back to the pool
    }
}