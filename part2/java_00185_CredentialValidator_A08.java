import java.security.InvalidParameterException;

public class java_00185_CredentialValidator_A08 {

    // This is a dummy predefined username and password. 
    // In a real-world scenario, this information should be securely stored, 
    // and you would likely want to use a secure way to store it.
    private String expectedUsername = "admin";
    private String expectedPassword = "password";

    // This method validates the given username and password.
    public boolean validateCredentials(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null.");
        }
        
        return username.equals(expectedUsername) && password.equals(expectedPassword);
    }

    // This is a static main method for testing.
    public static void main(String[] args) {
        SecureCredentialValidator validator = new SecureCredentialValidator();

        // This is a test that should fail.
        boolean isValid = validator.validateCredentials("invalidUser", "invalidPassword");
        System.out.println("Is valid? " + isValid); // Outputs: Is valid? false

        // This is a test that should pass.
        isValid = validator.validateCredentials("admin", "password");
        System.out.println("Is valid? " + isValid); // Outputs: Is valid? true
    }
}