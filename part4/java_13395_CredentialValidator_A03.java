import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_13395_CredentialValidator_A03 {

    public static void main(String[] args) {
        // Create a secure random number generator
        SecureRandom sr = new SecureRandom();

        // Create a message digest instance for SHA-256
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            // Handle exception gracefully
            throw new RuntimeException(e);
        }

        // Generate a random salt
        byte[] salt = new byte[16];
        sr.nextBytes(salt);

        // Get password from user input
        String password = "password";

        // Hash the password with the salt
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());

        // Now you can store the hashed password and the salt in the database
        // For this example, we will simply log the hashed password
        System.out.println(new String(hashedPassword));
    }
}