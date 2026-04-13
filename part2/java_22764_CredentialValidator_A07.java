import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslServer;
import javax.security.sasl.SaslException;

public class java_22764_CredentialValidator_A07 implements SaslClient {
    private Subject subject;
    private CallbackHandler callbackHandler;

    public java_22764_CredentialValidator_A07(Subject subject, CallbackHandler callbackHandler) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
    }

    public void notify(String saslId, Object message) {
        // No-op
    }

    public Object getNextMsg(String saslId) {
        return null;
    }

    public void abort(String saslId) {
        // No-op
    }

    public SaslServer createSaslServer() {
        return new MySaslServer();
    }

    public CallbackHandler getCallbackHandler() {
        return callbackHandler;
    }

    public Subject getSubject() {
        return subject;
    }

    private class MySaslServer implements SaslServer {
        public void start(Callback[] callbacks) {
            // No-op
        }

        public void abort(Callback[] callbacks) {
            // No-op
        }

        public Object getNextMsg(String saslId, Object msg) {
            // No-op
            return null;
        }

        public void forget(String saslId) {
            // No-op
        }
    }
}