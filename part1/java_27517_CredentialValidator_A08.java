public class java_27517_CredentialValidator_A08 {

    public boolean validateCredentials(String username, String password) {
        // We'll assume a password is strong enough if it:
        // - It contains at least 8 characters
        // - It contains a number
        // - It contains a lowercase letter
        // - It contains an uppercase letter
        // - It contains a special character
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
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        }
        return true;
    }
}