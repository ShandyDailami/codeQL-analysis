import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_15469_CredentialValidator_A08 {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final MessageDigest SHA256_HASH = getSHA256Hash();

    private static MessageDigest getSHA256Hash() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError("SHA-256 hashing algorithm should always be available", e);
        }
    }

    public String createSalt() {
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public String createHash(String password, String salt) {
        String saltedPassword = salt + password;
        byte[] saltedPasswordBytes = saltedPassword.getBytes(StandardCharsets.UTF_8);
        byte[] hashedPasswordBytes = SHA256_HASH.digest(saltedPasswordBytes);
        return Base64.getEncoder().encodeToString(hashedPasswordBytes);
    }

    public boolean validatePassword(String password, String salt, String storedHash) {
        String hash = createHash(password, salt);
        return hash.equals(storedHash);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String password = "password";
        String salt = validator.createSalt();
        String hashedPassword = validator.createHash(password, salt);

        // validate the hashed password
        boolean isValid = validator.validatePassword(password, salt, hashedPassword);
        System.out.println("Is valid: " + isValid);
    }
}