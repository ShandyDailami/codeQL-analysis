import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_25056_JDBCQueryHandler_A01 {

    // The JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {

        Connection conn = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query
            String sql = "SELECT * FROM users";
            conn.prepareStatement(sql).execute();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection
            if (conn != null) {
                try { conn.close(); }
                catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }
}