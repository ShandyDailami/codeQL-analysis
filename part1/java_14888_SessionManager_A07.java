import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_14888_SessionManager_A07 {
    private static final String ALGORITHM = "SHA-256";

    // SecureRandom is used to generate a random salt
    private static SecureRandom sr = new SecureRandom();

    // MessageDigest is used to generate a hash of the password
    private static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            // This will never happen, as we're using a SHA-256 algorithm
            throw new RuntimeException(e);
        }
    }

    // Method to create a hash of a password
    public static String createHash(String password) {
        byte[] hashedPassword = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    // Method to verify if a password matches a hashed password
    public static boolean verifyPassword(String password, String hashedPassword) {
        return createHash(password).equals(hashedPassword);
    }

    // Method to generate a secure random salt
    public static String generateSalt() {
        return Base64.getEncoder().encodeToString(sr.generateSeed(16));
    }

    public static void main(String[] args) {
        // Create a new session
        String password = "password123";
        String salt = generateSalt();
        String hashedPassword = createHash(password + salt);

        // Verify a password
        String passwordToVerify = "password123";
        String hashedPasswordToVerify = createHash(passwordToVerify + salt);
        boolean isVerified = verifyPassword(passwordToVerify, hashedPassword);

        // Print the results
        System.out.println("Verified: " + isVerified);
    }
}