import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_05897_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Load MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // 2. Establish a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // 3. Prepare a statement (SQL query)
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);

            // 4. Bind parameters
            pstmt.setString(1, "testUser");
            pstmt.setString(2, "testPassword");

            // 5. Execute the statement
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. Close the resources
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}