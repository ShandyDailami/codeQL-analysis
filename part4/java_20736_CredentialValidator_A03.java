import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.UsernameNotFoundException;

public class java_20736_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,}$");

    @Override
    public String validate(String arg0) throws UsernameNotFoundException {
        return validate(arg0);
    }

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public boolean validate(String arg0) throws PasswordChangeException {
        Matcher usernameMatcher = USERNAME_PATTERN.matcher(arg0);
        if (!usernameMatcher.matches()) {
            throw new UsernameNotFoundException("Invalid username");
        }

        Matcher passwordMatcher = PASSWORD_PATTERN.matcher(arg0);
        if (!passwordMatcher.matches()) {
            throw new PasswordChangeException("Password is weak");
        }

        return true;
    }

}