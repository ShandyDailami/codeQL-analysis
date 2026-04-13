import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Base64;

public class java_16332_CredentialValidator_A08 {

    private HashMap<String, String> credentials;

    public java_16332_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        // Initialize credentials
        this.credentials.put("user1", this.encryptPassword("password1"));
        this.credentials.put("user2", this.encryptPassword("password2"));
    }

    private String encryptPassword(String password) {
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

    public boolean validateCredentials(String username, String password) {
        String encryptedPassword = this.encryptPassword(password);
        return encryptedPassword != null && encryptedPassword.equals(this.credentials.getOrDefault(username, null));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate credentials
        System.out.println(validator.validateCredentials("user1", "password1")); // true
        System.out.println(validator.validateCredentials("user1", "wrongPassword")); // false
        System.out.println(validator.validateCredentials("user3", "password3")); // false
    }
}