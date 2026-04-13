public class java_34361_CredentialValidator_A08 {
    public boolean validate(String password) {
        // Check if the password is too short
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains a number
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check if the password contains a lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if the password contains an uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // If all checks pass, the password is valid
        return true;
    }
}