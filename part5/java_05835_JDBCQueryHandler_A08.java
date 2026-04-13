import java.sql.*;

public class java_05835_JDBCQueryHandler_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a Connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Create a Statement
            stmt = conn.createStatement();

            // Step 3: Execute the Query
            String sql = "SELECT * FROM my_table WHERE id = " + 1; // This should be replaced with a secure operation
            rs = stmt.executeQuery(sql);

            // Step 4: Process the Result Set
            while (rs.next()) {
                // Do something with rs
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the ResultSet, Statement, and Connection
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
}