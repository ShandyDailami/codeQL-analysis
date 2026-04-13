public class java_31169_CredentialValidator_A08 {
    public static boolean validate(String username, String password) {
        // Check if username is empty
        if (username == null || username.trim().isEmpty()) {
            return false;
        }

        // Check if password is empty
        if (password == null || password.trim().isEmpty()) {
            return false;
        }

        // Check if username is longer than 10 characters
        if (username.length() > 10) {
            return false;
        }

        // Check if password is longer than 20 characters
        if (password.length() > 20) {
            return false;
        }

        // Check if the username contains only alphanumeric characters
        if (!username.matches("^[a-zA-Z0-9]*$")) {
            return false;
        }

        // Check if the password contains only alphanumeric characters
        if (!password.matches("^[a-zA-Z0-9]*$")) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }
}