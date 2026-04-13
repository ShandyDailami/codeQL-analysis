import java.util.regex.Pattern;

public class java_20830_CredentialValidator_A03 {

    private static final Pattern UPPERCASE = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE = Pattern.compile("[a-z]");
    private static final Pattern DIGIT = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_CHAR = Pattern.compile("[~!@#$%^&*()_=+\\-{}[\\\\]|<>?]");

    public boolean isStrongPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (password.length() < 8) {
            return false;
        }
        if (!UPPERCASE.matcher(password).find()) {
            return false;
        }
        if (!LOWERCASE.matcher(password).find()) {
            return false;
        }
        if (!DIGIT.matcher(password).find()) {
            return false;
        }
        if (!SPECIAL_CHAR.matcher(password).find()) {
            return false;
        }
        return true;
    }
}