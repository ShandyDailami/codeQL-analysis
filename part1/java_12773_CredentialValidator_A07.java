import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_12773_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_12773_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    @Override
    public Subject doIdentityValidation(CallbackHandler callbackHandler)
            throws IOException, UnsupportedCallbackException {
        // No identity validation logic here, so return null
        return null;
    }

    @Override
    public Subject doCallbackHandler(CallbackHandler callbackHandler)
            throws IOException, UnsupportedCallbackException {
        // No callback logic here, so return null
        return null;
    }

    @Override
    public Subject doGetPassword(String arg0, String arg1) throws InsufficientAuthenticationException {
        String password = this.credentials.get(arg1);
        if (password == null) {
            throw new InsufficientAuthenticationException("Invalid username or password");
        }
        return null;
    }

    @Override
    public void initialize(String arg0, Map<String, String> arg1) {
        // No initialization logic here
    }

    @Override
    public boolean validate(Subject subject, Object credentials) throws AuthenticationException {
        if (credentials instanceof String) {
            if (((String) credentials).equals(this.credentials.get(subject.getPrincipal().getName()))) {
                return true;
            }
        }
        return false;
    }
}