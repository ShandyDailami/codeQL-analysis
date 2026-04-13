import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_23185_CredentialValidator_A08 {

    // Secure random for password generation
    private final SecureRandom random = new SecureRandom();

    // Message digest for password hashing
    private MessageDigest digest;

    public java_23185_CredentialValidator_A08() {
        try {
            this.digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            // This should never happen, as we're using the SHA-256 algorithm.
            throw new ExceptionInInitializerError(e);
        }
    }

    // Method for generating a secure random password
    public String generateSecurePassword(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }

    // Method for checking if a password is secure
    public boolean isPasswordSecure(String password, String securedPassword) {
        String securePassword = hashPassword(password);
        return securePassword.equals(securedPassword);
    }

    // Method for hashing a password
    public String hashPassword(String password) {
        byte[] hashedPassword = digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Generate a secure password
        String password = validator.generateSecurePassword(10);
        System.out.println("Generated Password: " + password);

        // Check if a password is secure
        String securedPassword = validator.hashPassword(password);
        System.out.println("Is Password Secure? " + validator.isPasswordSecure(password, securedPassword));
    }
}