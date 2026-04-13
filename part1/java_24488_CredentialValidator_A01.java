import java.util.regex.Pattern;

public class java_24488_CredentialValidator_A01 {
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[~！@#$%^&*()_+\\-=\\{\\}\\[\\\\];\'\\\",.<>\\?\\[\\]\\|\\\\]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("[0-9]");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");

    public boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        return (hasSpecialChar(password) && hasDigit(password) && hasUpperCase(password) && hasLowerCase(password));
    }

    private boolean hasSpecialChar(String password) {
        return SPECIAL_CHAR_PATTERN.matcher(password).find();
    }

    private boolean hasDigit(String password) {
        return DIGIT_PATTERN.matcher(password).find();
    }

    private boolean hasUpperCase(String password) {
        return UPPERCASE_PATTERN.matcher(password).find();
    }

    private boolean hasLowerCase(String password) {
        return LOWERCASE_PATTERN.matcher(password).find();
    }
}