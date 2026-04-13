import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_19840_CredentialValidator_A08 {

    // Function to hash the password using SHA-256
    private String hashPassword(String password) {
        String hashedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            hashedPassword = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return hashedPassword;
    }

    // Function to validate the password
    public boolean validatePassword(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
    }

    // Main method
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        
        // Password to hash
        String password = "password";

        // Hash password
        String hashedPassword = validator.hashPassword(password);
        
        // Print hashed password
        System.out.println("Hashed Password: " + hashedPassword);

        // Validate password
        boolean isValid = validator.validatePassword(password, hashedPassword);
        System.out.println("Is password valid? " + isValid);
    }
}