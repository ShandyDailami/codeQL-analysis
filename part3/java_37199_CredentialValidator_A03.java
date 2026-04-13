public class java_37199_CredentialValidator_A03 {

    // Method to validate a username and password
    public boolean validate(String username, String password) {
        // Check if the username is the same as the password
        if (username.equals(password)) {
            // If true, return true to indicate successful validation
            return true;
        } else {
            // If false, return false to indicate failed validation
            return false;
        }
    }

    // Method to authenticate a username and password
    public void authenticate(String username, String password) {
        // Validate the credentials
        if (validate(username, password)) {
            // If validated, print a success message
            System.out.println("Authentication successful.");
        } else {
            // If not validated, print an error message
            System.out.println("Authentication failed.");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create an instance of CredentialValidator
        CredentialValidator validator = new CredentialValidator();
        // Test the authenticate method
        validator.authenticate("test", "test");
    }
}