public class java_38079_CredentialValidator_A01 {

    // Simple password validation. It checks if the password is at least 8 characters long,
    // contains a digit, a lowercase letter, and an uppercase letter.
    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        return true;
    }

    // Simple username validation. It checks if the username only contains alphanumeric characters and underscores.
    public boolean validateUsername(String username) {
        if (username == null) {
            return false;
        }
        if (!username.matches("^[a-zA-Z0-9_]*$")) {
            return false;
        }
        return true;
    }
}