import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class java_08677_CredentialValidator_A03 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Predefined password (hashed with SHA-256)
    private static final String PREDEFINED_PASSWORD = "5baa61e4c9b93f3f0682250b6cf8331b7ee6851a09e980401810a6057116ae22";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Load database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open database connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare SQL statement
            String sql = "SELECT password FROM users WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "testuser");

            // Execute SQL statement
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");

                // Check password
                if (isPasswordValid(dbPassword)) {
                    System.out.println("Password is valid.");
                } else {
                    System.out.println("Password is not valid.");
                }
            } else {
                System.out.println("No user found.");
            }

            // Close database connection
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPasswordValid(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        String hash = Base64.getEncoder().encodeToString(hashInBytes);
        return hash.equals(PREDEFINED_PASSWORD);
    }
}