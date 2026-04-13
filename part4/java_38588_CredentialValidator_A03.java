import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_38588_CredentialValidator_A03 {

    public boolean validate(String passwordAttempt, String salt, String password) throws NoSuchAlgorithmException {
        // Generate a hash of the password attempt using the SHA-256 algorithm
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(salt.getBytes(StandardCharsets.UTF_8));
        byte[] hashBytes = digest.digest(passwordAttempt.getBytes(StandardCharsets.UTF_8));
        String hash = Base64.getEncoder().encodeToString(hashBytes);

        // Compare the hash of the password attempt with the hashed password
        return hash.equals(password);
    }
}