import java.sql.*;

public class java_01965_JDBCQueryHandler_A08 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            String sql;

            // Insert a new user
            sql = "INSERT INTO users (id, name, age) VALUES (1, 'John', 25)";
            stmt.executeUpdate(sql);

            // Update an existing user
            sql = "UPDATE users SET age = 26 WHERE id = 1";
            stmt.executeUpdate(sql);

            // Delete a user
            sql = "DELETE FROM users WHERE id = 1";
            stmt.executeUpdate(sql);

            // Step 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Finally block to close resources
        }
    }
}