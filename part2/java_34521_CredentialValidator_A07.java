public class java_34521_CredentialValidator_A07 {

    // Hard-coded set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the credentials
    public static boolean validate(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Credentials validated successfully!");
            return true;
        } else {
            System.out.println("Invalid username or password!");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validation
        validate("admin", "password");  // Should print: "Credentials validated successfully!"
        validate("wrong", "username");  // Should print: "Invalid username or password!"
    }
}