import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_41892_JDBCQueryHandler_A07 {

    // Step 1: Establish a database connection using Java's standard JDBC libraries.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 2: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 4: Prepare a statement
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);

            // Step 5: Set parameters for the prepared statement
            pstmt.setString(1, "testUser");
            pstmt.setString(2, "testPassword");

            // Step 6: Execute the prepared statement
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 7: Close the resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}