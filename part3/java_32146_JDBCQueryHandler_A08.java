import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_32146_JDBCQueryHandler_A08 {

    // This is the connection URL, username, and password.
    // You should replace these with your actual details.
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register the driver in the JVM
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Execute a SQL statement
            stmt = conn.createStatement();
            String sql = "INSERT INTO users (username, password) VALUES ('user1', 'password1')";
            stmt.executeUpdate(sql);

            // Step 4: Clean up
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error while closing the database connection: " + e.getMessage());
            }
        }
    }
}