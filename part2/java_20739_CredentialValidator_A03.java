import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_20739_CredentialValidator_A03 {
    // Simple hashing function
    public String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    // Simple comparison function
    public boolean validatePassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }

    // Main method
    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Creating a password
        String password = "myPassword";

        // Hashing the password
        String hashedPassword = validator.hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);

        // Validating the password
        boolean isValid = validator.validatePassword(password, hashedPassword);
        System.out.println("Is valid password: " + isValid);
    }
}