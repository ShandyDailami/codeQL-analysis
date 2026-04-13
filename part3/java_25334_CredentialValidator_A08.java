import java.security.InvalidParameterException;
import java.util.regex.Pattern;

public class java_25334_CredentialValidator_A08 {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean validate(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password is null");
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new InvalidParameterException("Password does not meet requirements");
        }

        return true;
    }
}