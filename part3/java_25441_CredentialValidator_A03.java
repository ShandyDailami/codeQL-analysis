public class java_25441_CredentialValidator_A03 {
    // Hardcoded set of valid credentials
    private String validUsername = "admin";
    private String validPassword = "password";

    // A method that validates a username and password
    public boolean validate(String username, String password) {
        // Check if the provided username matches the hardcoded username
        if (username.equals(validUsername)) {
            // Check if the provided password matches the hardcoded password
            if (password.equals(validPassword)) {
                // The credentials are valid
                return true;
            }
        }
        // The credentials are not valid
        return false;
    }
}