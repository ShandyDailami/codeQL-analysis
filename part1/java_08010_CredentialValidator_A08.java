import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_08010_CredentialValidator_A08 {
    public static void main(String[] args) throws Exception {
        String password = "password";
        byte[] passwordBytes = password.getBytes();

        // Create a secure random generator
        SecureRandom secureRandom = new SecureRandom();

        // Generate a random salt
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);

        // Create a MessageDigest instance for SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Hash the password with the salt
        byte[] hash = digest.digest(passwordBytes);

        // Combine the salt and hash
        byte[] hashAndSalt = new byte[hash.length + salt.length];
        System.arraycopy(hash, 0, hashAndSalt, 0, hash.length);
        System.arraycopy(salt, 0, hashAndSalt, hash.length, salt.length);

        // Convert the combined array to a Base64 string
        String securePassword = Base64.getEncoder().encodeToString(hashAndSalt);

        System.out.println("Secure Password: " + securePassword);

        // Validate the secure password against the hard-coded password
        if (securePassword.equals(password)) {
            System.out.println("Credentials Valid!");
        } else {
            System.out.println("Credentials Invalid!");
        }
    }
}