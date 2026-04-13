// Imports
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.Subject;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.auth.AuthException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// CredentialValidator
public class java_15952_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {
    private static final String USER_ROLE = "USER";

    @Override
    public List<String> getRequestedAttributes() {
        return Arrays.asList("username", "password");
    }

    @Override
    public void validate(Subject subject, String requestedAttributes[],
            CallbackHandler callbackHandler, Object state)
            throws IOException, UnsupportedCallbackException, AuthException {

        Callback[] callbacks = new Callback[requestedAttributes.length];
        for (int i = 0; i < requestedAttributes.length; i++) {
            callbacks[i] = new Callback() {
                public void handle(Callback[] callbacks) {
                    // No-op, as we don't care about the password.
                }
            };
        }

        callbackHandler.handle(callbacks);

        if ("password".equals(requestedAttributes[0])) {
            throw new AccessControlException("Authentication failure");
        }
    }
}