import javax.naming.AuthenticationException;

public class java_08103_CredentialValidator_A07 {
    // Define a static user and password. You may replace these with actual values in a real scenario.
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    // Define a method to authenticate the user.
    public boolean authenticate(String user, String password) {
        // Check if the user and password matches. In a real scenario, use a secure way to compare passwords.
        if (user.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    // Define a method to validate the credentials.
    public void validateCredentials(String user, String password) throws AuthenticationException {
        // First, authenticate the user.
        boolean isAuthenticated = authenticate(user, password);

        // If not authenticated, throw an AuthenticationException.
        if (!isAuthenticated) {
            throw new AuthenticationException("Invalid username or password.");
        }

        // If authenticated, print a success message.
        System.out.println("Successfully authenticated.");
    }

    // Start the program with 'java'.
    public static void main(String[] args) {
        // Create an instance of CredentialValidator.
        CredentialValidator validator = new CredentialValidator();

        // Try to validate the credentials.
        try {
            validator.validateCredentials(USERNAME, PASSWORD);
        } catch (AuthenticationException e) {
            // Handle the AuthenticationException.
            System.out.println("Error: " + e.getMessage());
        }
    }
}