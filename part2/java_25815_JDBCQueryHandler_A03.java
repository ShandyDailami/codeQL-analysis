import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_25815_JDBCQueryHandler_A03 {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "myusername";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Prepare a statement
            pstmt = conn.prepareStatement("SELECT password FROM users WHERE username = ?");
            pstmt.setString(1, "myusername");

            // Execute the statement
            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Password: " + rs.getString("password"));
            } else {
                System.out.println("No password found for user myusername");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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