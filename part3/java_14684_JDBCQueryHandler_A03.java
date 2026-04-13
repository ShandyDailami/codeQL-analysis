import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_14684_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        // Step 1: Establish database connection
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Prepare SQL query
        String sql = "SELECT * FROM users WHERE name = ?";

        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);

            // Step 3: Inject user input into SQL query
            String userInput = "John"; // This could be a hardcoded value, a parameter from an HTTP request, or any other source of data
            pstmt.setString(1, userInput);

            // Step 4: Execute query
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up
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