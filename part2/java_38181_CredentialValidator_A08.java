import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.Guard;
import java.util.Iterator;

public class java_38181_CredentialValidator_A08 implements CredentialValidatorImpl, CallbackHandler {
    private String user;
    private String password;
    private boolean authenticated = false;

    public java_38181_CredentialValidator_A08(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public boolean validate(Subject subject, AccessControlContext context) throws java.security.AuthenticationException {
        Guard guard = context.getGuard(AccessControlContext.DEFAULTS);
        if (guard.getSubject().getName().equals(user) && guard.authenticate(password.toCharArray())) {
            authenticated = true;
            return true;
        }
        return false;
    }

    public boolean getAuthenticationStatus() {
        return authenticated;
    }

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            callbacks[i].done();
        }
    }
}