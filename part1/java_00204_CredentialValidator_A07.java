import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.message.MessageException;
import javax.security.auth.message.MessageState;
import javax.security.auth.message.StateChange;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;

public class java_00204_CredentialValidator_A07 implements AuthenticationService, LoginModule {

    private Map<String, String> creds = new HashMap<>();

    public java_00204_CredentialValidator_A07() {
        creds.put("user", Base64.getEncoder().encodeToString("user".getBytes()));
        creds.put("password", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    @Override
    public boolean validate(Subject subject, Object credentials, Object password) {
        String encodedCreds = Base64.getEncoder().encodeToString((credentials.toString().getBytes()));
        return encodedCreds.equals(creds.get(password.toString()));
    }

    @Override
    public boolean commit() {
        return true;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> options)
            throws UnsupportedCallbackException, MessageException {
        // No setup needed
    }

    @Override
    public boolean supportsStoredCredentials() {
        return true;
    }
}