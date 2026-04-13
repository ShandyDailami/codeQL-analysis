import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_38835_SessionManager_A03 {
    // Define a static String variable for username
    private static String username = "username";
    private static String password = "password";
    private static String url = "jdbc:mysql://localhost:3306/mydatabase";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Step 1: Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Set auto-commit mode to false
            conn.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        try {
            // Perform operations with the connection
            // For example, update a record
            // ...

            // Step 4: Commit the transaction
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}