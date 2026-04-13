import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_27122_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            pstmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");

            // Execute the statement
            pstmt.setString(1, "testUser");
            pstmt.setString(2, "testPassword");
            pstmt.executeUpdate();

            // Commit the transaction
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Disconnect from the database
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}