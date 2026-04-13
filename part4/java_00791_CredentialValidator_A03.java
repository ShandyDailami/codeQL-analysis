import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_00791_CredentialValidator_A03 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";

    public boolean validate(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Step 1: Load MySQL Driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare a statement
            String SQL = "SELECT USER_ID FROM USERS WHERE USERNAME = ?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            // Step 4: Handle result
            if (rs.next()) {
                String dbUser = rs.getString("USER_ID");
                if (dbUser.equals(password)) {
                    return true;
                }
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return false;
    }
}