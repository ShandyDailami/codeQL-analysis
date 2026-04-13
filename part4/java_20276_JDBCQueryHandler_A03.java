import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_20276_JDBCQueryHandler_A03 {

    // URL of the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    // Username and password for database
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare the statement
            String sql = "SELECT * FROM my_table WHERE id = ?";
            pstmt = conn.prepareStatement(sql);

            // Set the parameter value
            pstmt.setInt(1, 100);

            // Step 4: Execute the statement
            pstmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up the statement and connection pool
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