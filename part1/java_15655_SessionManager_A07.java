import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_15655_SessionManager_A07 {
    private String username;
    private String password;

    // Constructor
    public java_15655_SessionManager_A07(String username, String password) {
        this.username = username;
        this.password = hashPassword(password);
    }

    // Method to hash password
    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to authenticate user
    public boolean authenticate(String attempt) {
        return hashPassword(attempt).equals(password);
    }
}