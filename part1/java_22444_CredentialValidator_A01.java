public class java_22444_CredentialValidator_A01 {

    // Static credentials for validation
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate credentials
    public static boolean validate(String username, String password) {
        // If the provided username and password match, return true
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        }

        // If the provided credentials do not match, return false
        return false;
    }
}