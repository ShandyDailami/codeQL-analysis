public class java_09351_CredentialValidator_A08 {

    // Minimum length of a username
    private static final int MIN_USERNAME_LENGTH = 5;

    // Maximum length of a password
    private static final int MAX_PASSWORD_LENGTH = 20;

    // List of special characters allowed in password
    private static final String ALLOWED_SPECIAL_CHARACTERS = "!@#$%^&*()_+=-[]{};':\",.<>?/|`~";

    // List of allowed characters in password
    private static final String ALLOWED_PASSWORD_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // List of allowed digits in password
    private static final String ALLOWED_DIGITS = "0123456789";

    public boolean isValidUsername(String username) {
        return username != null && username.length() >= MIN_USERNAME_LENGTH;
    }

    public boolean isValidPassword(String password) {
        if (password == null || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }
        if (!hasAtLeastOneSpecialCharacter(password) || !hasAtLeastOneDigit(password)) {
            return false;
        }
        if (!hasAllowedCharacters(password)) {
            return false;
        }
        return true;
    }

    private boolean hasAtLeastOneSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (ALLOWED_SPECIAL_CHARACTERS.contains(c + "")) {
                return true;
            }
        }
        return false;
    }

    private boolean hasAtLeastOneDigit(String password) {
        for (char c : password.toCharArray()) {
            if (ALLOWED_DIGITS.contains(c + "")) {
                return true;
            }
        }
        return false;
    }

    private boolean hasAllowedCharacters(String password) {
        for (char c : password.toCharArray()) {
            if (!ALLOWED_PASSWORD_CHARACTERS.contains(c + "")) {
                return false;
            }
        }
        return true;
    }
}