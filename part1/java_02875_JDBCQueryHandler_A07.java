import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_02875_JDBCQueryHandler_A07 {

    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());

    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "user";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT password FROM users WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "user");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                // Now you can use the password for further operations related to security.
                System.out.println("Password: " + password);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error in accessing database", ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error in closing database connection", ex);
           
            }
        }
    }
}