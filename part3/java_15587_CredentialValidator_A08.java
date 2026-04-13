public class java_15587_CredentialValidator_A08 {
    // The minimum length of the password
    private static final int MIN_PASSWORD_LENGTH = 8;

    // The maximum length of the password
    private static final int MAX_PASSWORD_LENGTH = 16;

    // The minimum number of digits in the password
    private static final int MIN_DIGITS = 1;

    // The minimum sequence of characters in the password
    private static final String MIN_SEQUENCE_OF_CHARACTERS = "0123456789";

    // The maximum sequence of characters in the password
    private static final String MAX_SEQUENCE_OF_CHARACTERS = "9876543210";

    // The minimum sequence of characters not allowed in the password
    private static final String FORBIDDEN_SEQUENCE_OF_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Method to validate the password
    public boolean validate(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH
                || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        int digits = 0;
        boolean hasDigit = false;
        boolean hasForbiddenCharacters = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digits++;
                hasDigit = true;
            }
            if (FORBIDDEN_SEQUENCE_OF_CHARACTERS.contains(Character.toString(c))) {
                hasForbiddenCharacters = true;
            }
        }

        if (!hasDigit || !hasForbiddenCharacters) {
            return false;
        }

        if (digits < MIN_DIGITS) {
            return false;
        }

        if (digits > MAX_DIGITS) {
            return false;
        }

        if (password.equals(MIN_SEQUENCE_OF_CHARACTERS) || password.equals(MAX_SEQUENCE_OF_CHARACTERS)) {
            return false;
        }

        return true;
    }
}