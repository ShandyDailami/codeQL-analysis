import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_03523_CredentialValidator_A01 implements CredentialValidator {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])";
    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    @Override
    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            return false;
        }

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            return false;
        }

        return true;
    }
}