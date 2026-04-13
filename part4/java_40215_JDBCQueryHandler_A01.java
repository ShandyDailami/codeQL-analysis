import java.sql.*;

public class java_40215_JDBCQueryHandler_A01 {
    // The connection pool data source name
    private static final String DATASOURCE_NAME = "myDS";

    // The JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPool();

        // Create a connection
        try {
            Connection con = cp.getConnection();

            // Prepare the statement
            String query = "SELECT * FROM users WHERE name=?";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set the parameter value
            pstmt.setString(1, "John");

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Define the ConnectionPool class
    private static class ConnectionPool {
        private BlockingQueue<Connection> queue = new LinkedBlockingQueue<>();

        // Number of connections to maintain in the pool
        private static final int POOL_SIZE = 10;

        // Initialize the connection pool data source
        private java_40215_JDBCQueryHandler_A01() {
            for (int i = 0; i < POOL_SIZE; i++) {
                try {
                    Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
                    queue.put(con);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Get a connection from the pool
        Connection getConnection() {
            try {
                return queue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            return null;
        }
    }
}