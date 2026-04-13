import java.util.regex.Pattern;

public class java_22923_CredentialValidator_A01 {

    private static final Pattern SPECIAL_CHARACTER_PATTERN =
            Pattern.compile("[~\\^\\+\\{\\}\\\[\\]\\|\\?\\*\\(\\)\\+\\-=\\;\\'\\\"\\\\\\\\\\\\\\]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("[0-9]");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");

    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        if (!(SPECIAL_CHARACTER_PATTERN.matcher(password).find()
                && DIGIT_PATTERN.matcher(password).find()
                && UPPERCASE_PATTERN.matcher(password).find()
                && LOWERCASE_PATTERN.matcher(password).find()) {
            return false;
        }

        return true;
    }
}