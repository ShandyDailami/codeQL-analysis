import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_41795_CredentialValidator_A07 {
    private static final MessageDigest digest = MessageDigest.getInstance("SHA-256");

    // A random salt for each user
    private final String salt;

    public java_41795_CredentialValidator_A07() throws NoSuchAlgorithmException {
        // Create a random salt for each user
        this.salt = Base64.getEncoder().encodeToString(SecureRandom.getInstance().generateSeed(16));
    }

    public String createHash(String password) {
        return Base64.getEncoder().encodeToString(digest.digest((password + salt).getBytes(StandardCharsets.UTF_8)));
    }

    public boolean validate(String password, String hash) {
        return hash.equals(createHash(password));
    }
}