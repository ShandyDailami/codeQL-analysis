import java.sql.*;

public class java_33057_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute a query
            String sql = "SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            rs = stmt.executeQuery(sql);

            // Step 4: Process the results
            while (rs.next()) {
                System.out.println("Found user!");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Step 6: Clean up
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}