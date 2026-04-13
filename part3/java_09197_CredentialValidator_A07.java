public class java_09197_CredentialValidator_A07 {
    // Hardcoded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // No external frameworks or libraries required, only built-in ones.

    // Method to validate the username and password
    public static boolean validate(String username, String password) {
        // If the username and password match the hardcoded values, return true
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Test the validate method
        boolean isAuthenticated = validate("admin", "password");
        if (isAuthenticated) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}