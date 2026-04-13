import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_30266_CredentialValidator_A03 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Generate a random password
        String password = validator.generateRandomPassword(10);

        // Hash the password using SHA-256
        String hashedPassword = validator.hashPassword(password);

        // Check if the password is valid
        boolean isValid = validator.validatePassword(hashedPassword, password);

        System.out.println("Is valid: " + isValid);
    }

    // Method to generate a random password
    private String generateRandomPassword(int length) {
        SecureRandom random = new SecureRandom();
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~";
        String password = new String(charset.repeat(length));
        return random.choose(password.toCharArray(), length);
    }

    // Method to hash a password using SHA-256
    private String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = digest.digest(password.getBytes());
        return bytesToHex(hash);
    }

    // Method to validate a password
    private boolean validatePassword(String expected, String actual) {
        return expected.equals(hashPassword(actual));
    }

    // Method to convert byte array to hexadecimal string
    private String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }
}