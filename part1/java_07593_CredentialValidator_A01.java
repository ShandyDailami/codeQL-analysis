import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthorizationCallback;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;

public class java_07593_CredentialValidator_A01 implements SaslClient, CallbackHandler {

    private String username;
    private String password;

    public java_07593_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Subject getSubjectCredentials(Subject subject) throws SaslException {
        // This should return the credentials of the user
        return subject;
    }

    public void afterLogin(Subject subject) throws SaslException {
        // Nothing to do here
    }

    public CallbackHandler getCallbackHandler() {
        return this;
    }

    public boolean afterLogout(Subject subject) throws SaslException {
        // Nothing to do here
        return true;
    }

    public void handleCallback(AuthorizationCallback callback) throws UnsupportedCallbackException {
        // Nothing to do here
    }

    public SaslClient createSaslClient() throws SaslException {
        // Nothing to do here
        return null;
    }

    public void login(String username, String password) throws SaslException {
        // Nothing to do here
    }
}