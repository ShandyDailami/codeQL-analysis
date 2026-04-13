import java.sql.*;

public class java_18599_JDBCQueryHandler_A03 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/testdb";

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
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Perform SQL query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE id = " + getUserIdFromInput();
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the result set
            while (rs.next()) {
                System.out.println("Found user " + rs.getString("username"));
            }

            // Close the connection and statement
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
       
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    // Assume getUserIdFromInput() is a method that returns user id from input
    private static String getUserIdFromInput() {
        // This is a placeholder, it will be replaced with real code
        return "1";
    }
}