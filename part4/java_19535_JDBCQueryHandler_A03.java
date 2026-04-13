import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_19535_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a connection
            conn = DriverManager.getConnection(url, username, password);

            // 3. Prepare a statement
            String sql = "SELECT * FROM users WHERE username = ?";
            pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");

            // 4. Use the statement set the parameter and execute the query
            pstmt.setString(1, "testUser");
            pstmt.execute();

            // 5. Process the results
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String user = rs.getString("username");
                System.out.println("User: " + user);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. Clean up
            if (pstmt != null) {
                try { pstmt.close(); } catch(SQLException e) {}
            }
            if (conn != null) {
                try { conn.close(); } catch(SQLException e) {}
            }
            if (rs != null) {
                try { rs.close(); } catch(SQLException e) {}
            }
        }
    }
}