public class java_30854_CredentialValidator_A03 {
    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate credentials
    public static boolean validateCredentials(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    // Entry point for testing
    public static void main(String[] args) {
        // Testing with valid credentials
        if (validateCredentials("admin", "password")) {
            System.out.println("Valid credentials");
        // Testing with invalid credentials
        } else {
            System.out.println("Invalid credentials");
        }
    }
}