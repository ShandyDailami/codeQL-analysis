public class java_31415_CredentialValidator_A08 {
    public boolean validatePassword(String password) {
        // Check if the password is too short
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains a digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check if the password contains a special character
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        }

        return true;
    }
}