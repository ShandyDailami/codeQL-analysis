public class java_02967_CredentialValidator_A07 {

    // Array of predefined users and their passwords
    private static final String[][] credentials = {
        { "user1", "password1" },
        { "user2", "password2" },
        { "user3", "password3" },
    };

    // Method to authenticate a user
    public boolean authenticate(String username, String password) {
        for (String[] credential : credentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Try to authenticate with valid credentials
        if (validator.authenticate("user1", "password1")) {
            System.out.println("Authenticated successfully!");
        } else {
            System.out.println("Authentication failed!");
        }

        // Try to authenticate with invalid credentials
        if (!validator.authenticate("invalid", "credentials")) {
            System.out.println("Invalid authentication!");
        } else {
            System.out.println("Authentication should have failed!");
        }
    }
}