import java.security.InvalidParameterException;

public class java_41919_CredentialValidator_A07 {

    // Define a predefined set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the provided username and password
    public boolean validateCredentials(String username, String password) {
        // Check if the provided username matches the predefined set
        if (!username.equals(USERNAME)) {
            throw new InvalidParameterException("Invalid username");
        }

        // Check if the provided password matches the predefined set
        if (!password.equals(PASSWORD)) {
            throw new InvalidParameterException("Invalid password");
       
        // If both username and password match, return true
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        try {
            validator.validateCredentials("admin", "password");
            System.out.println("Successfully authenticated");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
    }
}