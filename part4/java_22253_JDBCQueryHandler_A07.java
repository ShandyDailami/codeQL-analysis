import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_22253_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            conn = DriverManager.getConnection(url, username, password);

            // SQL query
            String sql = "SELECT * FROM Users WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 123);
            rs = pstmt.executeQuery();

            // Process the result
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("Name: " + name);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close database resources
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* can't do anything */ }
            }
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) { /* can't do anything */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* can't do anything */ }
            }
        }
    }
}