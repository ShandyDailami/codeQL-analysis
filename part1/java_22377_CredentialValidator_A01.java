public class java_22377_CredentialValidator_A01 {

    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Check if username and password match
    public static boolean validate(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println(validate("admin", "password"));  // Should print true
        System.out.println(validate("admin", "wrongpassword"));  // Should print false
    }
}