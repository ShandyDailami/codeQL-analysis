//import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_11724_CredentialValidator_A03 {
    // Method to validate user credentials
    public boolean validateUserCredentials(String username, String password, String hashedPassword) {
        // This method should compare the password entered by the user with the hashed password stored in the database
        // But, in this example, we'll just return true or false for simplicity
        return password.equals(hashedPassword);
    }

    // Method to hash passwords
    public String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String username = "testuser";
        String password = "testpassword";

        String hashedPassword = validator.hashPassword(password);
        if (validator.validateUserCredentials(username, password, hashedPassword)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}