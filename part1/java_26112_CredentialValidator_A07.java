import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_26112_CredentialValidator_A07 {

    // Pre-defined password to hash
    private static final String PREDEFINED_PASSWORD = "password";

    public boolean validate(String passwordAttempt) throws NoSuchAlgorithmException {
        // Hash the provided password
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(passwordAttempt.getBytes());

        // Convert the hash to a Base64 string
        String hashedPassword = Base64.getEncoder().encodeToString(hash);

        // Compare the hashed password with the pre-defined password
        return hashedPassword.equals(Base64.getEncoder().encodeToString(PREDEFINED_PASSWORD.getBytes()));
    }
}