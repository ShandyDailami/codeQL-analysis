import java.sql.*;
import java.util.concurrent.*;

public class java_25015_SessionManager_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";
    private static ExecutorService executorService;

    static {
        executorService = Executors.newCachedThreadPool();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void main(String[] args) {
        executorService.execute(new Runnable() {
            public void run() {
                try {
                    Connection conn = getConnection();
                    // Perform security-sensitive operations with conn...
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}