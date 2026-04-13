import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_28443_JDBCQueryHandler_A03 {
    // The URL, username, and password should never be hard-coded,
    // they should be retrieved from a secure source.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Get a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

            // Step 4: Process the results
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Cleanup
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}