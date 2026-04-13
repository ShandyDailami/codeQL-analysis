import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_32392_JDBCQueryHandler_A03 {

    // Connection URL
    private static final String url = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String username = "root";
    private static final String password = "password";

    // SQL query
    private static final String sql = "SELECT * FROM my_table";

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to database
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Execute SQL statement
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // Step 4: Process ResultSet
            while (rs.next()) {
                System.out.println("Record 1: " + rs.getString("column1"));
                System.out.println("Record 2: " + rs.getString("column2"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close database resources
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) {}
            }
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) {}
            }
        }
    }
}