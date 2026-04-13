import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

public class java_13193_CredentialValidator_A01 implements LoginModule {

    private Map<String, String> credentials;

    public java_13193_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("alice", "password1");
        this.credentials.put("bob", "password2");
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> options)
            throws LoginException, UnsupportedCallbackException {
        // Not needed here for a simple example
    }

    @Override
    public boolean validate(Subject subject, String username, Object password) throws LoginException {
        String expectedPassword = this.credentials.get(username);
        if (expectedPassword != null && expectedPassword.equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean commit() throws LoginException {
        // This is called when a session is started and may be used to perform any setup
        return true;
    }

    @Override
    public void cleanup(Subject subject) throws LoginException {
        // This is called when a session is ended and may be used to perform any cleanup
    }
}