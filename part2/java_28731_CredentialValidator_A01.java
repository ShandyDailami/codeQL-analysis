public class java_28731_CredentialValidator_A01 {

    // Check if password is strong enough
    public static boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!hasUpperCase(password)) {
            return false;
        }
        if (!hasLowerCase(password)) {
            return false;
        }
        if (!hasDigit(password)) {
            return false;
        }
        if (!hasSpecialCharacter(password)) {
            return false;
        }
        if (containsSequence(password)) {
            return false;
        }
        return true;
    }

    // Check if password contains upper case
    private static boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    // Check if password contains lower case
    private static boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    // Check if password contains digit
    private static boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    // Check if password contains special character
    private static boolean hasSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*()_+\-=\\\\{}\\|;:<'>,,.?/].*");
    }

    // Check if password contains sequence of characters
    private static boolean containsSequence(String password) {
        return password.contains("12345") || password.contains("abc123") || password.contains("123abc") || password.contains("abcdef") || password.contains("defgh") || password.contains("ghij");
    }
}