import java.security.SecureRandom;
import java.util.Base64;

public class java_08118_CredentialValidator_A03 {

    // This is a placeholder password. In real scenario, this password should be hashed and stored in a secure place.
    private static final String[] KNOWN_PASSWORDS = {"password1", "secret", "admin", "123456"};

    private SecureRandom random = new SecureRandom();

    // Simple base64 encoder to make it more secure
    private Base64.Encoder encoder = Base64.getEncoder();

    public boolean validateCredentials(String passwordAttempt) {
        String encryptedPasswordAttempt = encoder.encodeToString(passwordAttempt.getBytes());

        for (String password : KNOWN_PASSWORDS) {
            String encryptedPassword = encoder.encodeToString(password.getBytes());

            if (encryptedPasswordAttempt.equals(encryptedPassword)) {
                return true; // Valid password
            }
        }

        return false; // Invalid password
    }
}