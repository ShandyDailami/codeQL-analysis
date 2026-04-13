import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_13655_CredentialValidator_A07 implements CallbackHandler {

    // Part of the solution A07_AuthFailure 
    private static class MyPrivilegedAction implements PrivilegedAction<AccessControlContext> {

        private final Class<? extends AccessControlContext> acc;

        private java_13655_CredentialValidator_A07(Class<? extends AccessControlContext> acc) {
            this.acct = acc;
        }

        @Override
        public AccessControlContext run() {
            try {
                return acc.newInstance();
            } catch (Exception ex) {
                throw new AssertionError(ex);
            }
        }
    }

    @Override
    public void handle(Callback[] callbacks) throws AuthenticationException, UnsupportedCallbackException {
        AccessControlContext acc = AccessControlContext.unavailable();
        for (Callback callback : callbacks) {
            acc = (AccessControlContext) AccessController.doPrivileged(new MyPrivilegedAction(acc.getClass()), acc);
        }
        throw new AuthenticationException("Authentication failed");
    }
}