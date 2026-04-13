import java.util.regex.Pattern;

public class java_39043_CredentialValidator_A01 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final Pattern SPECIAL_CHARACTER_PATTERN = Pattern.compile("[" + SPECIAL_CHARACTERS + "]");
    private static final Pattern UPPERCASE_LETTER_PATTERN = Pattern.compile("[" + UPPERCASE_LETTERS + "]");
    private static final Pattern LOWERCASE_LETTER_PATTERN = Pattern.compile("[" + LOWERCASE_LETTERS + "]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("[" + DIGITS + "]");

    @Override
    public boolean validate(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!SPECIAL_CHARACTER_PATTERN.matcher(password).find()) {
            return false;
        }

        if (!UPPERCASE_LETTER_PATTERN.matcher(password).find()) {
            return false;
        }

        if (!LOWERCASE_LETTER_PATTERN.matcher(password).find()) {
            return false;
        }

        if (!DIGIT_PATTERN.matcher(password).find()) {
            return false;
        }

        return true;
    }
}