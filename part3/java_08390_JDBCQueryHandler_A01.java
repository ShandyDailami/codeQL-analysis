import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_08390_JDBCQueryHandler_A01 {

    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(DRIVER);

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Execute a query
            pstmt = conn.prepareStatement("SELECT * FROM Users WHERE username = ? AND password = ?");
            pstmt.setString(1, "admin");
            pstmt.setString(2, "password");
            rs = pstmt.executeQuery();

            // Step 4: Process the results
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up environment
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}