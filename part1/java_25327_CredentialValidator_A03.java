import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeRequiredException;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;

public class java_25327_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public boolean validate(Credential credential) throws LoginException {
        String password = credential.getPassword();
        Matcher matcher = PASSWORD_PATTERN.matcher(password);

        if (!matcher.matches()) {
            throw new LoginException("Password is not strong enough. Password must contain at least one number, one uppercase letter, one lowercase letter, one special character, and be at least 8 characters long.");
        }

        return true;
    }

    @Override
    public boolean validate(Credential credential, Object object) throws LoginException {
        return validate(credential);
    }

    @Override
    public boolean validate(Credential credential, Object object, String s) throws LoginException {
        return validate(credential);
    }

    @Override
    public boolean validate(Credential credential, Object object, String s, String s1) throws LoginException {
        return validate(credential);
    }
}