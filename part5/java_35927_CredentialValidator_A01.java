import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_35927_CredentialValidator_A01 {
    private final MessageDigest digest;
    private final SecureRandom random;

    public java_35927_CredentialValidator_A01() {
        try {
            this.digest = MessageDigest.getInstance("SHA-256");
            this.random = new SecureRandom();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String hashPassword(String password) {
        byte[] hash = this.digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        byte[] userHash = this.digest.digest(password.getBytes());
        byte[] storedHash = Base64.getDecoder().decode(hashedPassword);
        return MessageDigest.isEqual(userHash, storedHash);
    }

    public String generateSalt() {
        byte[] salt = new byte[16];
        this.random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public String hashPasswordWithSalt(String password, String salt) {
        String saltedPassword = password + salt;
        return hashPassword(saltedPassword);
    }
}