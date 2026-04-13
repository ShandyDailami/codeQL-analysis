import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.auth.SubjectBroker;
import java.security.auth.callback.PasswordCallback;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_15202_CredentialValidator_A03 implements SubjectBroker {
    private Set<String> allowedActions = new HashSet<>(Arrays.asList("LOGIN", "CHANGE_PASSWORD"));

    private class CallbackHandlerImpl implements CallbackHandler {
        private PasswordCallback callback;

        @Override
        public void initialize(String name, Map<String, ?> properties) {
            callback = new PasswordCallback(name, properties);
        }

        @Override
        public PasswordCallback getPasswordCallback() {
            return callback;
        }

        @Override
        public void handle(Callback[] callbacks) throws UnsupportedCallbackException, AccessControlException {
            for (Callback callback : callbacks) {
                if (callback instanceof PasswordCallback) {
                    PasswordCallback pc = (PasswordCallback) callback;
                    if (!allowedActions.contains(pc.getAction())) {
                        pc.setRequestedPassword("***");
                    }
                    return;
                }
                throw new UnsupportedCallbackException("Unsupported callback " + callback.getClass().getName());
            }
        }
    }

    @Override
    public Subject authenticate(Subject subject, String authzID, CallbackHandler callbackHandler, Map<String, ?> properties) throws IOException, AccessControlException {
        // no implementation needed, the default implementation in SubjectBroker is enough
        return subject;
    }

    @Override
    public Subject authenticate(String authzID, CallbackHandler callbackHandler, Map<String, ?> properties) throws IOException, AccessControlException {
        // no implementation needed, the default implementation in SubjectBroker is enough
        return null;
    }

    @Override
    public Subject getSubject(String authzID, CallbackHandler callbackHandler, Map<String, ?> properties) throws AccessControlException, IOException {
        // no implementation needed, the default implementation in SubjectBroker is enough
        return null;
    }

    @Override
    public Subject identify(String name, String authzID, CallbackHandler callbackHandler, Map<String, ?> properties) throws IOException, AccessControlException {
        // no implementation needed, the default implementation in SubjectBroker is enough
        return null;
    }
}