import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_00216_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_USERNAME = "user";
    private static final String DB_PASSWORD = "password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // SQL query
    private static final String SQL_QUERY = "SELECT * FROM users WHERE username = ? AND password = ?";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Prepare a statement
            pstmt = conn.prepareStatement(SQL_QUERY);

            // Set parameters
            pstmt.setString(1, "testUser"); // This should be the username you are trying to log in with
            pstmt.setString(2, "testPassword"); // This should be the password you are trying to log in with

            // Execute the statement
            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("User authenticated successfully!");
            } else {
                System.out.println("Invalid username or password!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Clean up resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}