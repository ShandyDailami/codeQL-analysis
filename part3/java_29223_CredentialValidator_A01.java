public class java_29223_CredentialValidator_A01 {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // Check if the provided credentials match the predefined ones
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator
        if (validate("admin", "password")) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}