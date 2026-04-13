public class java_31365_CredentialValidator_A03 {

    // The username and password to validate against
    private final String validUsername;
    private final String validPassword;

    // Constructor
    public java_31365_CredentialValidator_A03(String validUsername, String validPassword) {
        this.validUsername = validUsername;
        this.validPassword = validPassword;
    }

    // Method to validate the user's credentials
    public boolean validate(String username, String password) {
        // If the username and password match the valid ones, return true
        if (username.equals(validUsername) && password.equals(validPassword)) {
            return true;
        }
        // Otherwise, return false
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new CredentialValidator with a valid username and password
        CredentialValidator validator = new CredentialValidator("user", "password");

        // Validate the validator with some credentials
        boolean isValid = validator.validate("user", "password");

        // Print the result
        System.out.println("Is valid: " + isValid);
    }
}