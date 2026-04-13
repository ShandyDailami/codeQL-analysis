import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class java_12797_CredentialValidator_A01 {

    // Assume we have a database with a table named "users" with a column "password"
    private Connection conn;

    public java_12797_CredentialValidator_A01(Connection conn) {
        this.conn = conn;
    }

    public boolean validateCredentials(String username, String password) {
        String hashedPassword = getHashedPassword(password);
        String dbPassword = getHashedPasswordFromDatabase(username);

        return hashedPassword.equals(dbPassword);
    }

    private String getHashedPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getHashedPasswordFromDatabase(String username) {
        String query = "SELECT password FROM users WHERE username = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}