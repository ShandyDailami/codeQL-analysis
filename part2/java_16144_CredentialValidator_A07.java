import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.Guard;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class java_16144_CredentialValidator_A07 implements CallbackHandler {
    private Set<Guard> guards;

    public java_16144_CredentialValidator_A07() {
        guards = new HashSet<>();
    }

    @Override
    public Callback[] getCallbacks() {
        return new Callback[]{new UsernameCallback(), new PasswordCallback()};
    }

    @Override
    public void handle(Callback[] callbacks) throws AuthenticationException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernameCallback) {
                ((UsernameCallback) callback).setRequestedPassword("");
                ((UsernameCallback) callback).setRequestedUsername("");
            } else if (callback instanceof PasswordCallback) {
                ((PasswordCallback) callback).setRequestedPassword("");
            }
        }
    }

    private static class UsernameCallback extends UsernamePasswordCallback implements Callback {
        private String requestedUsername;

        public String getRequestedUsername() {
            return requestedUsername;
        }

        public void setRequestedUsername(String requestedUsername) {
            this.requestedUsername = requestedUsername;
        }
    }

    private static class PasswordCallback extends UsernamePasswordCallback implements Callback {
        private String requestedPassword;

        public String getRequestedPassword() {
            return requestedPassword;
        }

        public void setRequestedPassword(String requestedPassword) {
            this.requestedPassword = requestedPassword;
        }
    }

    public static void main(String[] args) throws Exception {
        CustomAuthenticator auth = new CustomAuthenticator();
        Subject subject = new Subject(new AccessControlContext(), auth, Collections.<AccessControlListener>emptyList(), Collections.<Guard>emptySet());
        subject.login();
    }
}