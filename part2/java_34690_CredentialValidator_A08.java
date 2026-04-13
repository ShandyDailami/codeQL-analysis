import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_34690_CredentialValidator_A08 {

    public static void main(String[] args) {
        String password = "12345"; // This should be a securely generated password
        String passwordHash = hashPassword(password);

        if (validateCredentials("12345", passwordHash)) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Credentials are invalid!");
        }
    }

    // Method to hash a password
    private static String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(password.getBytes());
        return new String(hash);
    }

    // Method to validate a password
    private static boolean validateCredentials(String passwordAttempt, String hashedPassword) {
        return hashedPassword.equals(hashPassword(passwordAttempt));
    }
}