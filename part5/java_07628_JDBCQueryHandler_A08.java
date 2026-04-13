import java.sql.*;

public class java_07628_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return;
        }

        // Step 2: Prepare a statement
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Statement failed: " + e.getMessage());
            return;
        }

        // Step 3: Execute a SQL query
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM Users");
            // Step 4: Process the results
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            System.out.println("Query execution failed: " + e.getMessage());
        } finally {
            // Step 5: Clean up resources
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
}