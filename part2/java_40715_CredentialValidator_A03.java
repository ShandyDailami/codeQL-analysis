public class java_40715_CredentialValidator_A03 {

    // Array of expected credentials
    private static final String[][] expectedCredentials = {
        {"admin", "password1"},
        {"user1", "password2"},
        {"user2", "password3"}
    };

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        for (String[] credential : expectedCredentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println("Valid credentials: " + validator.validateCredentials("admin", "password1"));
        System.out.println("Valid credentials: " + validator.validateCredentials("user1", "password2"));
        System.out.println("Valid credentials: " + validator.validateCredentials("user2", "password3"));
        System.out.println("Invalid credentials: " + validator.validateCredentials("invalid", "invalid"));
    }
}