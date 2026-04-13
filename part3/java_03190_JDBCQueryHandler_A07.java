import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_03190_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Checking for authentication failure
    private static final String AUTH_FAILURE_SQL = "SELECT * FROM Users WHERE username = ? AND password = ?";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare a statement
            pstmt = conn.prepareStatement(AUTH_FAILURE_SQL);

            // Step 4: Execute the statement
            pstmt.setString(1, "testUser");
            pstmt.setString(2, "testPassword");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Authentication failure");
            } else {
                System.out.println("No authentication failure");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the statement and connection
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