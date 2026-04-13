import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_17187_JDBCQueryHandler_A07 {

    // Define the database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myUser";
    private static final String PASS = "myPassword";

    public static void main(String[] args) {
        // Establish a connection to the database
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare the SQL statement
            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setString(1, "testUser");
            pstmt.setString(2, "testPassword");

            // Execute the query
            pstmt.execute();

        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error occurred while closing the database connection");
            }
        }
    }
}