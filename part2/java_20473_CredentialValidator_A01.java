public class java_20473_CredentialValidator_A01 {
    public static boolean validatePassword(String password) {
        // Check if password is null
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check if password contains at least one lowercase letter
        if (!hasLowerCase(password)) {
            return false;
        }

        // Check if password contains at least one digit
        if (!hasDigit(password)) {
            return false;
        }

        // Check if password contains at least one special character
        if (!hasSpecialCharacter(password)) {
            return false;
        }

        // If all checks pass, the password is valid
        return true;
    }

    private static boolean hasUpperCase(String password) {
        // Use a regular expression to check if a string contains an uppercase letter
        return password.matches(".*[A-Z].*");
    }

    private static boolean hasLowerCase(String password) {
        // Use a regular expression to check if a string contains a lowercase letter
        return password.matches(".*[a-z].*");
    }

    private static boolean hasDigit(String password) {
        // Use a regular expression to check if a string contains a digit
        return password.matches(".*[0-9].*");
    }

    private static boolean hasSpecialCharacter(String password) {
        // Use a regular expression to check if a string contains a special character
        return password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}