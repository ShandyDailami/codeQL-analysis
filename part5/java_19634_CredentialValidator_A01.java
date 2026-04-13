public class java_19634_CredentialValidator_A01 {
    // The user's input username
    private String username;

    // The user's input password
    private String password;

    // The expected username and password
    private String expectedUsername;
    private String expectedPassword;

    // Constructor
    public java_19634_CredentialValidator_A01(String username, String password, String expectedUsername, String expectedPassword) {
        this.username = username;
        this.password = password;
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    // Method to check if the entered credentials match the expected ones
    public boolean validateCredentials() {
        // If both the username and password match the expected ones, return true
        if (this.username.equals(this.expectedUsername) && this.password.equals(this.expectedPassword)) {
            return true;
        }

        // Otherwise, return false
        return false;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        // Create a new CredentialValidator with the expected credentials
        CredentialValidator validator = new CredentialValidator("admin", "password", "admin", "password");

        // Validate the credentials
        boolean isValid = validator.validateCredentials();

        // Print the result
        System.out.println("Is valid: " + isValid);
    }
}