public class java_27974_CredentialValidator_A01 {

    // Define common passwords
    private static final String[] COMMON_PASSWORDS = {"password", "123456", "qwerty", "admin", "1234567"};

    public boolean isValid(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if password is too short or too long
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Check if password contains common passwords
        for (String commonPassword : COMMON_PASSWORDS) {
            if (password.contains(commonPassword)) {
                return false;
            }
        }

        // Check if password contains uppercase, lowercase, digit and special characters
        if (!hasUpperCase(password) || !hasLowerCase(password) || !hasDigit(password) || !hasSpecialChar(password)) {
            return false;
        }

        // Password is valid
        return true;
    }

    private boolean hasUpperCase(String password) {
        // Use regex to check if password contains uppercase letters
        return password.matches(".*[A-Z].*");
    }

    private boolean hasLowerCase(String password) {
        // Use regex to check if password contains lowercase letters
        return password.matches(".*[a-z].*");
    }

    private boolean hasDigit(String password) {
        // Use regex to check if password contains digits
        return password.matches(".*[0-9].*");
    }

    private boolean hasSpecialChar(String password) {
        // Use regex to check if password contains special characters
        return password.matches(".*[!@#$%^&*(),.?\":{}|<>]*");
    }
}