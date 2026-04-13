import java.util.regex.Pattern;

public class java_20637_CredentialValidator_A08 {
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[^A-Za-z0-9]");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^A-Za-z0-9]).{8,}");

    public boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        if (!SPECIAL_CHAR_PATTERN.matcher(password).find()) {
            return false;
        }

        if (!PASSWORD_PATTERN.matcher(password).find()) {
            return false;
        }

        return true;
    }
}