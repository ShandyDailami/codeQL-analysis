import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_22496_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String url = "jdbc:mysql://localhost:3306/testdb";
            String user = "root";
            String password = "password";

            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url, user, password);

            // Step 3: Execute a query
            String sql = "SELECT * FROM Employee";
            pstmt = conn.prepareStatement("SELECT * FROM Employee");
            pstmt.executeQuery();

            // Step 4: Handle the ResultSet
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up
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