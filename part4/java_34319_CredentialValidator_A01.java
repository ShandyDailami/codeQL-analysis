import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_34319_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS_SET = SPECIAL_CHARACTERS + UPPERCASE_LETTERS + LOWERCASE_LETTERS + NUMBERS;

    public boolean validate(String password) {
        if (password.length() < 8) {
            return false;
        }

        Pattern pattern;

        pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }

        pattern = Pattern.compile("[a-z]");
        matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }

        pattern = Pattern.compile("[0-9]");
        matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }

        pattern = Pattern.compile("[" + SPECIAL_CHARACTERS + "]");
        matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }

        return true;
    }
}