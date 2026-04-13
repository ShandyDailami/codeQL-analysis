public class java_28184_CredentialValidator_A08 {
    // Hardcoded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the username and password
    public static boolean validate(String username, String password) {
        if (username != null && username.equals(USERNAME) && 
            password != null && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the credentials
        System.out.println(validate("admin", "password")); // Should print true
        System.out.println(validate("user", "wrongpassword")); // Should print false
    }
}