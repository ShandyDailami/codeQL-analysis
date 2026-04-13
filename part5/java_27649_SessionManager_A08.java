import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class java_27649_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private List<Connection> pool = new ArrayList<>();
    private int poolSize = 10;

    public java_27649_SessionManager_A08() {
        for (int i = 0; i < poolSize; i++) {
            pool.add(createConnection());
        }
    }

    private Connection createConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Connection getConnection() {
        if (pool.isEmpty()) {
            if (poolSize <= 0) {
                System.out.println("Maximum connections reached!");
                return null;
            }
            poolSize++;
            return createConnection();
        }
        Connection connection = pool.remove(pool.size() - 1);
        if (connection != null) {
            return connection;
        } else {
            return createConnection();
        }
    }

    public void releaseConnection(Connection connection) {
        pool.add(connection);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Example of using the session manager
        try {
            Connection connection = sessionManager.getConnection();
            // ...
            sessionManager.releaseConnection(connection);
        } catch (Exception e) {
            System.out.println("Error occurred while using the session manager: " + e.getMessage());
        }
    }
}