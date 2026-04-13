import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_10384_CredentialValidator_A08 {
    private final MessageDigest messageDigest;
    private final SecureRandom secureRandom;

    public java_10384_CredentialValidator_A08() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            secureRandom = new SecureRandom();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String createPasswordHash(String password) {
        byte[] salt = secureRandom.generateSeed(16);
        messageDigest.update(salt);
        byte[] hashedPassword = messageDigest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    public boolean validatePassword(String password, String hashedPassword) {
        byte[] salt = Base64.getDecoder().decode(hashedPassword);
        messageDigest.update(salt);
        byte[] hashedCheckPassword = messageDigest.digest(password.getBytes());
        return messageDigest.isEqual(hashedCheckPassword);
    }
}