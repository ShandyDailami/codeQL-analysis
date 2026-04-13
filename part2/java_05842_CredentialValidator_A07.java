import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamepassword.UsernamePasswordCallbackHandler;
import javax.security.auth.x500.X500Principal;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.auth.AuthException;
import java.security.Principal;

public class java_05842_CredentialValidator_A07 implements CredentialValidator {

    private UsernamePasswordCallbackHandler callbackHandler = new UsernamePasswordCallbackHandler();

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler, Object credentials) throws AuthException, AccessControlException {
        callbackHandler.getCallbacks().add(new Callback() {
            public void handle(Callback callback) throws IOException, UnsupportedCallbackException {
                callback.setUniqueId("uniqueId");
                callback.setPassword("password");
            }
        });

        Principal principal = subject.getPrincipal();
        if (principal instanceof X500Principal) {
            subject.getPrincipal().setName("admin");
        } else {
            subject.setPrincipal(new X500Principal("admin"));
        }

        return validate(subject, callbackHandler, credentials);
    }

    @Override
    public boolean getRequestedCredential(Subject subject, CallbackHandler callbackHandler, Object target) throws IOException, UnsupportedCallbackException, AccessControlException, AuthException {
        callbackHandler.getCallbacks().add(new Callback() {
            public void handle(Callback callback) throws IOException, UnsupportedCallbackException {
                callback.setPassword("password");
            }
        });

        return validate(subject, callbackHandler, target);
    }

    private boolean validate(Subject subject, CallbackHandler callbackHandler, Object credentials) throws AuthException, AccessControlException {
        return callbackHandler.validate(subject, new Callback[]{new Callback() {
            public void handle(Callback callback) throws IOException, UnsupportedCallbackException {
                callback.setPassword("password");
            }
        }), credentials);
    }
}