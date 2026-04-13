public class java_10961_CredentialValidator_A08 {
    // A known set of credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    // Method to check if a given username and password are valid
    public boolean isValidCredentials(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    // Main method to test the validator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing with valid credentials
        if (validator.isValidCredentials("user", "pass")) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }

        // Testing with invalid credentials
        if (validator.isValidCredentials("invalid", "invalid")) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}