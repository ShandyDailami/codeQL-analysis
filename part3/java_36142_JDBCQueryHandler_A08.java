import java.sql.*;

public class java_36142_JDBCQueryHandler_A08 {
    // Define the database url, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    // This method will execute the query and return the ResultSet
    public ResultSet executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Step 2: Create a statement
            stmt = conn.createStatement();
            // Step 3: Execute the query and return the result
            rs = stmt.executeQuery(query);
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return rs;
    }
}