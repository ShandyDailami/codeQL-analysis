// CredentialValidator class java_41429_CredentialValidator_A08 class CredentialValidator {

    // Method to validate password and username
    public boolean validate(String username, String password) {
        // Replace with your own logic for password and username validation
        // This example only returns true for valid usernames and passwords
        if (username != null && username.equals("admin") && password != null && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

// Main class
public class Main {

    // Main method
    public static void main(String[] args) {
        // Create a CredentialValidator instance
        CredentialValidator validator = new CredentialValidator();

        // Validate the credentials
        boolean isValid = validator.validate("admin", "password");

        // Print the result
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}