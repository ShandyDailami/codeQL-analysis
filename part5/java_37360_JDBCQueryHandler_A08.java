import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_37360_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root"; // Replace with your username
    private static final String PASS = "password"; // Replace with your password

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare the SQL statement
            String sql = "SELECT * FROM employees WHERE id = ?";
            pstmt = conn.prepareStatement(sql);

            // Step 4: Execute the statement
            pstmt.setInt(1, 123); // replace 123 with the id you're looking for
            rs = pstmt.executeQuery();

            // Step 5: Handle the result
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
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