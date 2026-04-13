public class java_37069_CredentialValidator_A07 {

    public static boolean isValid(String password) {
        // Check for minimum length (can be removed as legacy style)
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase letters
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check for numbers
        if (!hasNumber(password)) {
            return false;
        }

        // Check for special characters
        if (!hasSpecialChar(password)) {
            return false;
        }

        return true;
    }

    private static boolean hasUpperCase(String password) {
        // Legacy implementation, just checks if any character is uppercase
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasNumber(String password) {
        // Legacy implementation, just checks if any character is a number
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSpecialChar(String password) {
        // Legacy implementation, just checks if any character is a special character
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                return true;
            }
        }
        return false;
    }
}