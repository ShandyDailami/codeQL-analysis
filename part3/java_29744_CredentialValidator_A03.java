import java.util.regex.Pattern;

public class java_29744_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[~`!@#$%^&*()+=\\\\[\\\\\\\\\';\"\\\\\\\\\\\\\\]");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("[0-9]");

    @Override
    public boolean isValid(String username, String password) {
        if (hasRepeatedCharacters(username, password)) {
            return false;
        }

        if (!hasSpecialChar(password)) {
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

        return true;
    }

    private boolean hasRepeatedCharacters(String username, String password) {
        return username.contains(password) || password.contains(username);
    }

    private boolean hasSpecialChar(String password) {
        return SPECIAL_CHAR_PATTERN.matcher(password).find();
    }

    private boolean hasUpperCase(String password) {
        return UPPERCASE_PATTERN.matcher(password).find();
    }

    private boolean hasLowerCase(String password) {
        return LOWERCASE_PATTERN.matcher(password).find();
    }

    private boolean hasDigit(String password) {
        return DIGIT_PATTERN.matcher(password).find();
    }
}