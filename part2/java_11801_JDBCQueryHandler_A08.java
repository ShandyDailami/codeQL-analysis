import java.sql.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_11801_JDBCQueryHandler_A08 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/test";

    private BlockingQueue<Connection> connectionPool = new LinkedBlockingQueue<>(10);

    public java_11801_JDBCQueryHandler_A08() {
        // Create connection pool
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            for (int i = 0; i < 10; i++) {
                connectionPool.put(DriverManager.getConnection(URL, USERNAME, PASSWORD));
            }
        } catch (SQLException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() throws InterruptedException {
        return connectionPool.take();
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            connectionPool.put(connection);
        }
    }

    public ResultSet executeQuery(String query) throws InterruptedException, SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        closeConnection(connection);
        return result;
    }

    public void executeUpdate(String query) throws InterruptedException, SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        closeConnection(connection);
    }
}