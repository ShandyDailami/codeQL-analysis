// Import necessary libraries
import java.util.Base64;

public class java_37020_CredentialValidator_A01 {

    // Method to validate a user's credential
    public boolean validateUserCredential(String userName, String password) {
        String validUsername = "admin";
        String validPassword = "password";

        // Encoding the password to Base64
        String encodedPassword = Base64.getEncoder().encodeToString(validPassword.getBytes());

        // Comparing the entered username and password with the expected ones
        if (userName.equals(validUsername) && password.equals(encodedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validateUserCredential("admin", "password")); // Should print true
        System.out.println(validator.validateUserCredential("wrongUser", "wrongPassword")); // Should print false
    }
}