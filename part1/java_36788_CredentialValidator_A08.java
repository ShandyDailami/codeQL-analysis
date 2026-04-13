import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.PasswordChangeRequiredException;
import javax.security.auth.login.CredentialException;

public class java_36788_CredentialValidator_A08 implements CredentialValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public String validate(String arg0) throws CredentialException {
        Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = passwordPattern.matcher(arg0);

        if (!matcher.matches()) {
            throw new InvalidCredentialException("Password must contain at least one number, one uppercase and lowercase letter, one special character, and be at least 8 characters long");
        }

        return null;
    }

    @Override
    public boolean requires(String arg0) {
        return false;
    }

}