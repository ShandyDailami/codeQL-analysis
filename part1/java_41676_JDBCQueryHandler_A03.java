import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_41676_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare a statement
            String sql = "SELECT * FROM Users WHERE username = ?";
            pstmt = conn.prepareStatement("SELECT * FROM Users WHERE username = ?");

            // Step 4: Execute the statement
            pstmt.setString(1, "testUser");
            rs = pstmt.executeQuery();

            // Step 5: Process the ResultSet
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("username"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up the resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}