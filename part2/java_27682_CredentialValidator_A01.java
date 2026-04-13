public class java_27682_CredentialValidator_A01 {
    // Minimum password length
    private static final int MIN_PASSWORD_LENGTH = 8;

    // Check if the password contains at least one digit
    private static boolean containsDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    // Check if the password contains at least one uppercase letter
    private static boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    // Check if the password contains at least one lowercase letter
    private static boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    // Check if the password contains at least one special character
    private static boolean containsSpecialCharacter(String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    // Main method to validate password
    public static boolean validate(String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password length is enough
        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        // Check if password contains at least one digit
        if (!containsDigit(password)) {
            return false;
        }

        // Check if password contains at least one uppercase letter
        if (!containsUpperCase(password)) {
            return false;
        }

        // Check if password contains at least one lowercase letter
        if (!containsLowerCase(password)) {
            return false;
        }

        // Check if password contains at least one special character
        if (!containsSpecialCharacter(password)) {
            return false;
        }

        return true;
    }
}