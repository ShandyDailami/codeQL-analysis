public class java_19717_CredentialValidator_A08 {
    // Simple check to ensure password is at least 8 characters long
    private static boolean isPasswordStrong(String password) {
        return password.length() >= 8;
    }

    // Simple check to ensure password contains at least one uppercase letter
    private static boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    // Simple check to ensure password contains at least one lowercase letter
    private static boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    // Simple check to ensure password contains at least one digit
    private static boolean hasDigit(String password) {
        return password.matches(".*\\d.*");
    }

    // Simple check to ensure password contains at least one special character
    private static boolean hasSpecialChar(String password) {
        return password.matches(".*[~!@#$%^&*()_+\\-=\\\\{\\}\\|\\[\\]\\\\`\\;:'\"\\\\\\\\\\<>\\?\\s].*");
    }

    public static boolean validate(String password) {
        return isPasswordStrong(password) && hasUpperCase(password) && hasLowerCase(password) && hasDigit(password) && hasSpecialChar(password);
    }
}