import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_20649_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:your_database_url", "username", "password");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
            System.exit(1);
        }

        // Step 2: Execute a query
        String sql = "SELECT * FROM your_table";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            // The query result will be a ResultSet
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error executing the query.");
            e.printStackTrace();
        } finally {
            // Step 3: Close the connection
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Error closing the statement.");
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing the connection.");
                    e.printStackTrace();
                }
            }
        }
    }
}