import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_03943_JDBCQueryHandler_A03 {
    private BlockingQueue<String> queries = new LinkedBlockingQueue<>();
    private ConnectionPool connectionPool;

    public java_03943_JDBCQueryHandler_A03(String url, String username, String password, String driverClass) {
        try {
            Class.forName(driverClass);
            connectionPool = new ConnectionPool(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addQuery(String query) {
        queries.add(query);
    }

    public void processQueries() {
        while (true) {
            try {
                String query = queries.take();
                Connection connection = connectionPool.getConnection();
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(query);
                }
                connectionPool.releaseConnection(connection);
            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ConnectionPool {
        private BlockingQueue<Connection> pool = new LinkedBlockingQueue<>();
        private int initialSize;

        public java_03943_JDBCQueryHandler_A03(String url, String username, String password) {
            try {
                DriverManager.setDriver(DriverManager.getDriver("com.mysql.cj.jdbc.Driver"));
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    pool.add(DriverManager.getConnection(url, username, password));
                }
                initialSize = pool.size();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Connection getConnection() throws InterruptedException, SQLException {
            return pool.take();
        }

        public void releaseConnection(Connection connection) {
            if (pool.size() < initialSize) {
                pool.add(connection);
            } else {
                connection.close();
            }
        }
    }
}