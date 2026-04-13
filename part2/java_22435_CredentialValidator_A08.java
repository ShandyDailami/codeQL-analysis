import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_22435_CredentialValidator_A08 {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z]).{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public boolean isPasswordStrong(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new InvalidParameterException("Password is not strong enough");
        }

        return true;
    }
}