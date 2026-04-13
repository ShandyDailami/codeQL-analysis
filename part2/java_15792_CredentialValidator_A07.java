import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_15792_CredentialValidator_A07 implements CredentialValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public String validate(String arg0) throws CredentialException {
        Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = passwordPattern.matcher(arg0);

        if (!matcher.matches()) {
            throw new InvalidCredentialException("Password does not meet the required criteria (length, contains uppercase letter, lowercase letter, number and special character).");
        }
        return arg0;
    }

    @Override
    public boolean validate(String arg0, Object arg1) throws CredentialException {
        return validate(arg0);
    }

    @Override
    public boolean validate(String arg0, Object arg1, String arg2) throws CredentialException {
        return validate(arg0);
    }
}