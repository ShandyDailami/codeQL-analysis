import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_11052_JDBCQueryHandler_A08 {

    // DB connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // SQL queries
    private static final String PASSWORD_CHECK_QUERY = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare statement for password check
            pstmt = conn.prepareStatement(PASSWORD_CHECK_QUERY);

            // Set the input parameters
            pstmt.setString(1, "testuser"); // replace with actual username
            pstmt.setString(2, "password"); // replace with actual password

            // Execute the statement
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    System.out.println("Password is correct.");
                } else {
                    System.out.println("Password is incorrect.");
                }
            } else {
                System.out.println("Error: unable to execute query");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) { /* unable to do anything */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* unable to do anything */ }
            }
        }
    }
}