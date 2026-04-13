import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_10418_CredentialValidator_A08 {

    private static final String HARDCODED_PASSWORD = "securePassword";

    // Method to hash password
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to convert bytes to hex
    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    // Method to validate credential
    public static boolean validate(String password) {
        return hashPassword(password).equals(HARDCODED_PASSWORD);
    }

    public static void main(String[] args) {
        // Attempt to log in with different passwords
        System.out.println(validate("incorrectPassword")); // should print false
        System.out.println(validate("securePassword")); // should print true
    }
}