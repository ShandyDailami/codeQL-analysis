import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_18661_CredentialValidator_A01 {

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String ALGORITHM = "SHA-256";

    private String passwordHash;
    private String passwordSalt;

    // Constructor
    public java_18661_CredentialValidator_A01(String password) {
        this.passwordSalt = new String(Base64.getEncoder().encode(getSalt()), StandardCharsets.UTF_8);
        this.passwordHash = getPasswordHash(password, this.passwordSalt);
    }

    // Accessors
    public String getPasswordHash() {
        return passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    // Method to validate password
    public boolean isPasswordValid(String password, String hash, String salt) {
        return hash.equals(getPasswordHash(password, salt));
    }

    private String getPasswordHash(String password, String salt) {
        MessageDigest digest;
        byte[] hash;

        try {
            digest = MessageDigest.getInstance(ALGORITHM);
            digest.update(salt.getBytes(StandardCharsets.UTF_8));
            hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available!");
        }

        return Base64.getEncoder().encodeToString(hash);
    }
}