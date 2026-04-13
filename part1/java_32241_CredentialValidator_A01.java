public class java_32241_CredentialValidator_A01 {

    // Predefined list of allowed usernames and passwords
    private static final String[] ALLOWED_USERNAMES = {"user1", "user2", "user3"};
    private static final String[] ALLOWED_PASSWORDS = {"password1", "password2", "password3"};

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // If the usernames or passwords don't match any of the allowed values, return false
        if (!doesUsernameExist(username) || !doesPasswordExist(password)) {
            return false;
        }

        // If the usernames and passwords match, return true
        return true;
    }

    // Helper method to check if a username exists in the allowed list
    private boolean doesUsernameExist(String username) {
        for (String allowedUsername : ALLOWED_USERNAMES) {
            if (allowedUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check if a password exists in the allowed list
    private boolean doesPasswordExist(String password) {
        for (String allowedPassword : ALLOWED_PASSWORDS) {
            if (allowedPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}