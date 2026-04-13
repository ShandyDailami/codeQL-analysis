public class java_05540_CredentialValidator_A03 {

    // Pre-defined rules
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    // Public method to validate password
    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        if (!containsDigit(password)) {
            return false;
        }

        if (!containsUpperCase(password)) {
            return false;
        }

        if (!containsLowerCase(password)) {
            return false;
        }

        if (!containsSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    // Helper methods to check if a password contains a specific character
    private boolean containsDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[" + SPECIAL_CHARACTERS + "].*");
    }
}