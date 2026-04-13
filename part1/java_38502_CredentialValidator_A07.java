public class java_38502_CredentialValidator_A07 {
    // Using a static password to verify against
    private static final String VALID_PASSWORD = "password";

    // Realistic method to validate the username and password
    public boolean validate(String username, String password) {
        // If the username is not null and the password is not null and the password is equal to VALID_PASSWORD
        if (username != null && password != null && VALID_PASSWORD.equals(password)) {
            // Return true
            return true;
        } else {
            // Otherwise, return false
            return false;
        }
    }

    public static void main(String[] args) {
        // Create a new CredentialValidator instance
        CredentialValidator validator = new CredentialValidator();

        // Print a message if the credentials are valid
        if (validator.validate("username", "password")) {
            System.out.println("Credentials are valid");
        } else {
            System.out.println("Credentials are invalid");
        }
    }
}