import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_09059_CredentialValidator_A03 {

    public static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");

    public boolean isValid(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        if (!matcher.matches()) {
            return false;
        }

        return true;
    }
}