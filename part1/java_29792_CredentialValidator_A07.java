public class java_29792_CredentialValidator_A07 {

    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        // Check if provided username and password match the predefined credentials
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        }

        // If not, return false
        return false;
    }
}