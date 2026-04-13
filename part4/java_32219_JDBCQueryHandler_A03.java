import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_32219_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Main method
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users WHERE email='test@test.com'");

            // Step 4: Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name + ", Email: " + email);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* can't do anything */ }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { /* can't do anything */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* can't do anything */ }
            }
        }
    }
}