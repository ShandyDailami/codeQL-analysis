import java.sql.*;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class java_05197_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;
    private static final int MAX_POOL_SIZE = 10;
    private static final int THREADS = 10;
    private static final long KEEP_ALIVE_TIME = 60000;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.MILLISECONDS;
    private static BlockingQueue<Connection> connectionBlockingQueue;
    private static ExecutorService executorService;

    static {
        init();
    }

    private java_05197_SessionManager_A03() {}

    private static void init() {
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("autoReconnect", "true");
        properties.setProperty("useSSL", "false");
        properties.setProperty("verifyServerCertificate", "false");
        properties.setProperty("requireSSL", "false");

        try {
            connection = DriverManager.getConnection(URL, properties);
            connectionBlockingQueue = new ArrayBlockingQueue<>(MAX_POOL_SIZE);
            connectionBlockingQueue.add(connection);

            executorService = Executors.newFixedThreadPool(THREADS);
            for (int i = 0; i < THREADS; i++) {
                executorService.execute(new ConnectionWorker());
            }

            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static Connection getConnection() throws SQLException {
        return connectionBlockingQueue.take();
    }

    public static void returnConnection(Connection connection) {
        if (connection != null) {
            connectionBlockingQueue.add(connection);
        }
    }

    private static class ConnectionWorker implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Connection connection = SessionManager.getConnection();
                    if (connection != null) {
                        connection.setAutoCommit(false);
                        // Execute your SQL here
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}