public class java_12518_CredentialValidator_A03 {
    public boolean isValidUsername(String username) {
        // Simulate a length check
        if (username.length() < 5 || username.length() > 20) {
            return false;
        }

        // Simulate a check for special characters
        if (!username.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        return true;
    }

    public boolean isValidPassword(String password) {
        // Simulate a length check
        if (password.length() < 8 || password.length() > 20) {
            return false;
        }

        // Simulate a check for special characters
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        }

        return true;
    }

    public boolean isValidCredentials(String username, String password) {
        if (!isValidUsername(username) || !isValidPassword(password)) {
            return false;
        }

        return true;
    }
}