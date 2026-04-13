import java.sql.*;
import java.util.concurrent.*;

public class java_04505_JDBCQueryHandler_A01 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    private static ExecutorService executorService;

    public static void main(String[] args) {
        initExecutorService();

        // Simulate some access control violation operations
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                public void run() {
                    queryDB("SELECT * FROM users WHERE id = " + finalI);
                }
            });
        }

        executorService.shutdown();
    }

    private static void initExecutorService() {
        executorService = Executors.newFixedThreadPool(10);
    }

    private static void queryDB(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User ID: " + rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close database resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}