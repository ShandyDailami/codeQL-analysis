import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_16339_SessionManager_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    private BlockingQueue<Connection> queue;

    private static SessionManager instance;

    private java_16339_SessionManager_A08() {
        queue = new LinkedBlockingQueue<>(10);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < 10; i++) {
                Connection connection = DriverManager.getConnection(URL, USER, PASS);
                queue.put(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            queue.put(connection);
        }
    }
}