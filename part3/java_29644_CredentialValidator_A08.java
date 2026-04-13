import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_29644_CredentialValidator_A08 implements CredentialValidator {

    private Set<String> allowedUsernames = new HashSet<>(Arrays.asList("user1", "user2", "user3"));

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler, Object password) throws IOException, LoginException {
        if (subject == null) {
            throw new IllegalArgumentException("subject cannot be null");
        }
        if (callbackHandler == null) {
            throw new IllegalArgumentException("callbackHandler cannot be null");
        }
        if (password == null) {
            throw new IllegalArgumentException("password cannot be null");
        }
        Callback[] callbacks = callbackHandler.getCallbacks();
        if (callbacks == null) {
            throw new IllegalArgumentException("callbacks cannot be null");
        }
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackImpl = (UsernamePasswordCallback) callback;
                String name = callbackImpl.getIdentifier();
                if (!allowedUsernames.contains(name)) {
                    throw new LoginException("Invalid username: " + name);
                }
            }
        }
        return true;
    }
}