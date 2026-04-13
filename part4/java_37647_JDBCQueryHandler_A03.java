import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_37647_JDBCQueryHandler_A03 {

    public void performQuery(String url, String username, String password, String query) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Load SQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(url, username, password);

            // Create SQL query
            pstmt = conn.prepareStatement(query);

            // Execute SQL query
            pstmt.execute();

            // Close connection
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close PreparedStatement and Database Connection
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