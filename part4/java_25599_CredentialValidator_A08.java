public class java_25599_CredentialValidator_A08 implements CredentialValidator {

    // The minimum length of a password
    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    // The minimum number of uppercase letters in a password
    private static final int MINIMUM_UPPERCASE_LETTERS = 1;

    // The minimum number of lowercase letters in a password
    private static final int MINIMUM_LOWERCASE_LETTERS = 1;

    // The minimum number of digits in a password
    private static final int MINIMUM_DIGITS = 1;

    @Override
    public boolean validate(String username, String password, UserValidatorContext context) {
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int digitCount = 0;

        // Check if password is too short
        if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            return false;
        }

        // Check if password contains uppercase letter
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCaseCount++;
            }
        }

        // Check if password contains lowercase letter
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            }
        }

        // Check if password contains digit
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }

        // Check if password contains all required characters
        return upperCaseCount >= MINIMUM_UPPERCASE_LETTERS
                && lowerCaseCount >= MINIMUM_LOWERCASE_LETTERS
                && digitCount >= MINIMUM_DIGITS;
    }
}