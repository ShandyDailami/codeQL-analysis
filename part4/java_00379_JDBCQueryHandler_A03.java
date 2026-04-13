import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_00379_JDBCQueryHandler_A03 {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static ConnectionPool connectionPool;

    static {
        connectionPool = new ConnectionPool();
        for (int i = 0; i < 10; i++) {
            connectionPool.addConnection(createConnection());
        }
    }

    private static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 50; i++) {
            final int id = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    executeQuery(id);
                }
            });
        }

        executor.shutdown();
    }

    private static void executeQuery(int id) {
        Connection connection = connectionPool.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id = " + id);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("User " + username + " with id " + id + " and password " + password);
            }

            connectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static class ConnectionPool {
        private BlockingQueue<Connection> pool = new LinkedBlockingDeque<>(10);
        private List<Connection> connections = new ArrayList<>();

        public void addConnection(Connection connection) {
            pool.add(connection);
            connections.add(connection);
        }

        public Connection getConnection() {
            try {
                return pool.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void releaseConnection(Connection connection) {
            pool.add(connection);
        }
    }
}