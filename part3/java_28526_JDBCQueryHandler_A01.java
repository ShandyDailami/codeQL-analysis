import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_28526_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a statement
            String sql = "SELECT * FROM mytable";
            pstmt = conn.prepareStatement(sql);

            // Step 4: Execute the statement
            rs = pstmt.executeQuery();

            // Step 5: Process the ResultSet
            while (rs.next()) {
                System.out.println("Record 1: " + rs.getString("column_name"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* can't do anything, since rs is already null */ }
            }
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) { /* can't do anything, since pstmt is already null */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* can't do anything, since conn is already null */ }
            }
        }
    }
}