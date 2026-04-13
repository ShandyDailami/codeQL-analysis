public class java_09705_CredentialValidator_A07 {
    // Hardcoded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // If the provided username and password match the hardcoded credentials, return true
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        }
        // Otherwise, return false
        return false;
    }

    public static void main(String[] args) {
        // Test the validate method with hardcoded credentials
        boolean isValid = validate("admin", "password");
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}