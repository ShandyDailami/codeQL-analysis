import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_13084_CredentialValidator_A08 {

    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z]).{8,}$");

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        if (!matcher.matches()) {
            throw new InvalidParameterException("Password is not valid: " + matcher.group());
        }

        return true;
    }

}