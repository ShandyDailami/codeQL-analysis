public class java_07864_CredentialValidator_A01 {

    // The minimum password strength required for the user
    private static final int MIN_PASSWORD_LENGTH = 8;

    // The minimum number of uppercase letters required in the password
    private static final int MIN_UPPERCASE_LETTERS = 1;

    // The minimum number of lowercase letters required in the password
    private static final int MIN_LOWERCASE_LETTERS = 1;

    // The minimum number of digits required in the password
    private static final int MIN_DIGITS = 1;

    // The minimum number of non-alphanumeric characters required in the password
    private static final int MIN_NON_ALPHANUMERIC_CHARACTERS = 1;

    public boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        int passwordLength = password.length();

        if (passwordLength < MIN_PASSWORD_LENGTH) {
            return false;
        }

        int uppercaseLetters = 0;
        int lowercaseLetters = 0;
        int digits = 0;
        int nonAlphanumericCharacters = 0;

        char[] characters = password.toCharArray();
        for (char c : characters) {
            if (Character.isUpperCase(c)) {
                uppercaseLetters++;
            } else if (Character.isLowerCase(c)) {
                lowercaseLetters++;
            } else if (Character.isDigit(c)) {
                digits++;
            } else {
                nonAlphanumericCharacters++;
            }
        }

        if (uppercaseLetters < MIN_UPPERCASE_LETTERS || 
            lowercaseLetters < MIN_LOWERCASE_LETTERS || 
            digits < MIN_DIGITS || 
            nonAlphanumericCharacters < MIN_NON_ALPHANUMERIC_CHARACTERS) {
            return false;
        }

        return true;
    }
}