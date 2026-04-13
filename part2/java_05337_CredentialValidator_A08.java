public class java_05337_CredentialValidator_A08 {

    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final int PASSWORD_MIN_DIGITS = 2;
    private static final int PASSWORD_MIN_SPECIAL_CHARS = 2;

    public boolean isPasswordValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        int digitsCount = 0;
        int specialCharsCount = 0;

        // Check password length
        if (password.length() < PASSWORD_MIN_LENGTH) {
            return false;
        }

        // Check for digits
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitsCount++;
            }
        }
        if (digitsCount < PASSWORD_MIN_DIGITS) {
            return false;
        }

        // Check for special characters
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                specialCharsCount++;
            }
        }
        if (specialCharsCount < PASSWORD_MIN_SPECIAL_CHARS) {
            return false;
        }

        // Check for uppercase letters
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }

        return false;
    }
}