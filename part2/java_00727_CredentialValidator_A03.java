import java.util.regex.Pattern;

public class java_00727_CredentialValidator_A03 {
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[^a-zA-Z0-9]");

    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasDigit = SPECIAL_CHAR_PATTERN.matcher(password).find();
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");

        if (!(hasDigit && hasUpperCase && hasLowerCase)) {
            return false;
        }

        return true;
    }
}