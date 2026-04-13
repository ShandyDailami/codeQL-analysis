import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class java_01940_CredentialValidator_A03 {

    // A sample database connection
    private static Connection conn;

    // The SQL query to retrieve a password and user from the database
    private static final String SQL_QUERY = "SELECT password, user FROM users WHERE user = ?";

    // Method to hash the password
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to validate the password
    public static boolean validatePassword(String user, String password) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "password");

            PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
            pstmt.setString(1, user);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");
                return hashPassword(password).equals(dbPassword);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}