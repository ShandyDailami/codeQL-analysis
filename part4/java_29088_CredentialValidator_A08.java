public class java_29088_CredentialValidator_A08 {

    // Simple username and password for demonstration
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        // This method will validate the username and password against the static
        // values in this class. For a real-world application, the password would
        // be hashed and compared to a stored hash, not the plain text password.

        if (username != null && username.equals(USERNAME) &&
            password != null && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}