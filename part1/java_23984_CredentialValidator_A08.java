import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_23984_CredentialValidator_A08 {

    public static void main(String[] args) {
        validate("testUser", hash("password123"));
    }

    private static void validate(String username, String hashedPassword) {
        try {
            Connection conn = getConnection();
            String sql = "SELECT password FROM Users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (isValidPassword(hashedPassword, dbPassword)) {
                    System.out.println("Access granted for user: " + username);
                } else {
                    System.out.println("Access denied for user: " + username);
                }
            } else {
                System.out.println("User not found for user: " + username);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    private static boolean isValidPassword(String hashedPassword, String dbPassword) {
        // In a real-world application, you'd want to store the hash of the user's password securely
        // and compare it with the stored hash. This is a simplified example and may not be secure.
        return hashedPassword.equals(dbPassword);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:your_database_url", "username", "password");
    }
}