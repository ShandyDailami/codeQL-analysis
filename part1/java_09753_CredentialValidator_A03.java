import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_09753_CredentialValidator_A03 {

    // This is a simplified example, in a real application you would need to store the hashed password
    private final String hashedPassword = "$argon2id$v=19$m=65536,t=4,p=1$veC/Q18uLWsqGiQAAA$JuQBzVXVlJIiPJA1SXpGxDQ==";

    public boolean validateCredentials(String username, String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            String hashedInput = Base64.getEncoder().encodeToString(hashPassword);
            return hashedInput.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            // This should never happen, but we're catching it just in case
            e.printStackTrace();
            return false;
        }
    }
}