import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.CredentialValidator;
import javax.security.auth.login.CredentialException;

public class java_19159_CredentialValidator_A07 implements CredentialValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    public String validate(String arg0) throws CredentialException {
        Matcher matcher = pattern.matcher(arg0);
        if (!matcher.matches()) {
            throw new CredentialException("Invalid password. It must contain at least 8 characters, one uppercase letter, one lowercase letter, one number and one special character.");
        }
        return arg0;
    }

    @Override
    public String getCallerPrincipal() {
        return "Unknown";
    }

    @Override
    public String getId() {
        return "MyCredentialValidator";
    }

    @Override
    public boolean validate(CredentialContext context) throws CredentialException {
        return true;
    }

}