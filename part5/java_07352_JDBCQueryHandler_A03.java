import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_07352_JDBCQueryHandler_A03 {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private final static String USER = "myusername";
    private final static String PASS = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare the statement
            String sql = "SELECT * FROM Users WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 100); // This is a dummy ID, replace it with actual one

            // Step 4: Execute the statement
            rs = pstmt.executeQuery();

            // Step 5: Process the result set
            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("id"));
                System.out.println("User Name: " + rs.getString("name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up the resources
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* Can't do anything */ }
            }
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) { /* Can't do anything */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* Can't do anything */ }
            }
        }
    }
}