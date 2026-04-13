import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_23285_JDBCQueryHandler_A03 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    // The JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load the MySQL driver
            Class.forName(DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a new SQL query
            String query = "SELECT * FROM users WHERE username = ?";
            pstmt = conn.prepareStatement(query);

            // Set the user-provided input as the query parameter
            pstmt.setString(1, "bob");

            // Execute the query
            pstmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Clean up resources
            if (pstmt != null) {
                try {
                    pstmt.close();
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