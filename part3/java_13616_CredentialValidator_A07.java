import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_13616_CredentialValidator_A07 {
    // Credentials to validate
    private String username;
    private String password;

    // Database information
    private String dbUrl = "jdbc:mysql://localhost:3306/test";
    private String dbUser = "root";
    private String dbPassword = "root";

    public java_13616_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Connect to the database
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // Prepare the SQL statement
            stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            stmt.setString(1, this.username);
            stmt.setString(2, this.password);

            // Execute the query
            rs = stmt.executeQuery();

            if (rs.next()) {
                // A user was found with the provided credentials
                return true;
            } else {
                // No user was found
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}