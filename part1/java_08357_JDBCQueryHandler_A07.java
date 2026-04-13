import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_08357_JDBCQueryHandler_A07 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query
            pstmt = con.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?");
            pstmt.setString(1, "user1");
            pstmt.setString(2, "password1");
            rs = pstmt.executeQuery();

            // Verify if the query returned any result
            if (rs.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Step 6: Close the resources
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}