import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_25131_CredentialValidator_A03 {
    // Use a stronger message digest algorithm like SHA-256
    private static final String ALGORITHM = "SHA-256";

    // Use a secure random generator to generate a salt
    private static final SecureRandom random = new SecureRandom();

    // Create a password hasher
    private MessageDigest messageDigest;

    public java_25131_CredentialValidator_A03() {
        try {
            messageDigest = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available.");
        }
    }

    // Generate a random salt
    public String generateSalt() {
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return saltToString(salt);
    }

    // Convert a salt to a hexadecimal string
    private String saltToString(byte[] salt) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : salt) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // Hash a password and store the hash and the salt
    public String hashPassword(String password, String salt) {
        messageDigest.update(salt.getBytes());
        byte[] bytes = messageDigest.digest(password.getBytes());
        return bytesToString(bytes);
    }

    // Convert a hashed password back to a human-readable form
    private String bytesToString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // Validate a password against a hashed password and a salt
    public boolean validatePassword(String password, String salt, String hashedPassword) {
        return hashPassword(password, salt).equals(hashedPassword);
    }
}