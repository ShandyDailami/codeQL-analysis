import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_15496_JDBCQueryHandler_A01 {
    // URL of the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    // Username and password
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute SQL query
            rs = stmt.executeQuery("SELECT * FROM users WHERE role='ADMIN'");

            // Step 5: Handle the ResultSet
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Error in JDBC operation: " + e.getMessage());
        } finally {
            // Step 6: Close the resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error while closing connections: " + e.getMessage());
            }
        }
    }
}