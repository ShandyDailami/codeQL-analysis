import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_35442_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/test";

    // Main method to test the connection and run queries
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection to the database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a statement
            String sql = "SELECT * FROM users WHERE id = ?";
            pstmt = conn.prepareStatement(sql);

            // Step 4: Set the parameter and execute the statement
            pstmt.setInt(1, 1001); // replace with the id of the user you want to get
            rs = pstmt.executeQuery();

            // Step 5: Process the result
            while (rs.next()) {
                System.out.println("User id: " + rs.getInt("id"));
                System.out.println("User name: " + rs.getString("name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up
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