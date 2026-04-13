import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_39095_CredentialValidator_A01 {

    // This is a simple example, you should use a secure hash function
    private MessageDigest digest;

    public java_39095_CredentialValidator_A01() {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public boolean validateCredentials(String username, String password, String hashedPassword) {
        // Hashing the password using SHA-256
        String hashedInput = getHashedPassword(password);

        // Return whether the hashed input matches the stored password
        return hashedInput.equals(hashedPassword);
    }

    private String getHashedPassword(String password) {
        // Hash the password using SHA-256
        byte[] hash = digest.digest(password.getBytes());

        // Encode the hash into a Base64 string
        return Base64.getEncoder().encodeToString(hash);
    }
}