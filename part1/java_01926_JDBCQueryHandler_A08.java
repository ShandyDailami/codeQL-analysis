import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_01926_JDBCQueryHandler_A08 {
    // Our database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Prepare the statement
            String sql = "SELECT * FROM Employees WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1001); // We're using a hard-coded id for demonstration purposes

            // Step 4: Execute the statement
            rs = pstmt.executeQuery();

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("Name: " + name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up the resources
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