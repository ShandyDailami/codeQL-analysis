import java.sql.*;

public class java_41757_JDBCQueryHandler_A03 {
    // Define your database credentials here
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    // The method that handles the database operations
    public ResultSet executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement object
            stmt = conn.createStatement();

            // Step 3: Execute the query and get the result set
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection and statement
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) {}
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) {}
            }
        }

        // Return the result set
        return rs;
    }
}