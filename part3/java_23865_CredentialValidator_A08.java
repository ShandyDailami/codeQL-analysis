public class java_23865_CredentialValidator_A08 {

    // minimum length of password
    private static final int MIN_PASSWORD_LENGTH = 8;

    // password must contain at least one uppercase letter
    private static final String UPPERCASE_PATTERN = ".*[A-Z].*";

    // password must contain at least one lowercase letter
    private static final String LOWERCASE_PATTERN = ".*[a-z].*";

    // password must contain at least one digit
    private static final String DIGIT_PATTERN = ".*[0-9].*";

    // password must contain at least one special character
    private static final String SPECIAL_CHARACTER_PATTERN = ".*[~`!@#$%^&*()_=\\\\-\\+\\\\[{\\].*";

    // password must not be too short
    private static final String TOO_SHORT_MESSAGE = "Password is too short. It should be at least " + MIN_PASSWORD_LENGTH + " characters";

    // password must not be too long
    private static final String TOO_LONG_MESSAGE = "Password is too long. It should not exceed " + MIN_PASSWORD_LENGTH + " characters";

    // password must contain at least one special character
    private static final String SPECIAL_CHARACTER_PATTERN_MESSAGE = "Password must contain at least one special character";

    // password must contain at least one uppercase letter
    private static final String UPPERCASE_PATTERN_MESSAGE = "Password must contain at least one uppercase letter";

    // password must contain at least one lowercase letter
    private static final String LOWERCASE_PATTERN_MESSAGE = "Password must contain at least one lowercase letter";

    // password must contain at least one digit
    private static final String DIGIT_PATTERN_MESSAGE = "Password must contain at least one digit";

    public boolean isValidPassword(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            System.out.println(TOO_SHORT_MESSAGE);
            return false;
        }

        if (password.length() > MIN_PASSWORD_LENGTH) {
            System.out.println(TOO_LONG_MESSAGE);
            return false;
        }

        if (!password.matches(UPPERCASE_PATTERN)) {
            System.out.println(UPPERCASE_PATTERN_MESSAGE);
            return false;
        }

        if (!password.matches(LOWERCASE_PATTERN)) {
            System.out.println(LOWERCASE_PATTERN_MESSAGE);
            return false;
        }

        if (!password.matches(DIGIT_PATTERN)) {
            System.out.println(DIGIT_PATTERN_MESSAGE);
            return false;
        }

        if (!password.matches(SPECIAL_CHARACTER_PATTERN)) {
            System.out.println(SPECIAL_CHARACTER_PATTERN_MESSAGE);
            return false;
        }

        System.out.println("Password is valid");
        return true;
    }
}