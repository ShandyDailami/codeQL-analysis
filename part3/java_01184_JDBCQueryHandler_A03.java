import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_01184_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/dbname";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Prepare a statement
            pstmt = conn.prepareStatement("SELECT * FROM users WHERE name = ?");
            pstmt.setString(1, "testUser");

            // Execute the statement
            pstmt.execute();

            // Handle the result set
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close the statement and connection
            if (pstmt != null) {
                try { pstmt.close(); } catch(SQLException e) { /* can't do anything */ }
            }
            if (conn != null) {
                try { conn.close(); } catch(SQLException e) { /* can't do anything */ }
            }
        }
    }
}