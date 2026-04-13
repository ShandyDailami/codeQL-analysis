public class java_33620_CredentialValidator_A08 {

    // Hard-coded credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        // Check if the provided username matches the hard-coded username
        if (username.equals(USERNAME)) {
            // Check if the provided password matches the hard-coded password
            if (password.equals(PASSWORD)) {
                return true; // Credentials are valid
            } else {
                return false; // Password is incorrect
            }
        } else {
            return false; // Username is incorrect
        }
    }

}