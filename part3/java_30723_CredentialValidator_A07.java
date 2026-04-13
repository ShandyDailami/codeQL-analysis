import java.util.regex.Pattern;
import javax.naming.AuthenticationException;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnavailableCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_30723_CredentialValidator_A07 implements CallbackHandler {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");

    private CallbackHandler callbackHandler;

    public java_30723_CredentialValidator_A07(CallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }

    @Override
    public Credential validationResult(Subject subject, String userName, String password) throws LoginException, AuthenticationException {
        if (!USERNAME_PATTERN.matcher(userName).matches()) {
            throw new AuthenticationException("Invalid username");
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new AuthenticationException("Invalid password");
        }

        return null; // valid credentials
    }

    @Override
    public Credential getPassword(String userName, String callingPrincipal, String callingAccessToken) throws LoginException, AuthenticationException {
        // Not used, because we don't actually need a password here
        return null;
    }

    @Override
    public void validate(Subject subject, String userName, String password) throws LoginException, AuthenticationException {
        // Not used, because we don't actually need to validate the credentials here
    }

    @Override
    public boolean commit(Subject subject, String userName, String password) throws LoginException, AuthenticationException {
        // Not used, because we don't actually need to save the credentials here
        return true;
    }

    @Override
    public boolean abort(Subject subject, String userName, String password) throws LoginException, AuthenticationException {
        // Not used, because we don't actually need to save the credentials here
        return true;
    }
}