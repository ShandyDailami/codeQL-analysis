public class java_19087_CredentialValidator_A07 {

    // Method to validate a username and password.
    public boolean validateCredentials(String username, String password) {
        // For simplicity, we assume that the username is always valid and the password is a valid length.
        // In a real application, you would need to validate these conditions.

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        if (username.length() < 5 || password.length() < 8) {
            return false;
        }

        if (!username.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        if (!password.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        // If all conditions are met, return true.
        return true;
    }
}