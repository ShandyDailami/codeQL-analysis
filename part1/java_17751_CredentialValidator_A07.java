import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.security.AccessControlContext;
import java.security.GuaranteedAccessException;
import java.security.auth.Subject;
import java.security.auth.callback.CallbackHandler;
import java.security.AccessControl;

public class java_17751_CredentialValidator_A07 implements CallbackHandler {

    private String expectedUsername = "test";
    private String expectedPassword = "test";

    @Override
    public boolean getCallbackHandler(CallbackHandler callbackHandler) throws UnsupportedCallbackException {
        return false;
    }

    @Override
    public void handle(Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernameCallback) {
                UsernameCallback cb = (UsernameCallback) callback;
                cb.setRequested(expectedUsername);
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback cb = (PasswordCallback) callback;
                cb.setRequested(expectedPassword);
            }
        }
        throw new UnsupportedCallbackException();
    }

    public static class UsernameCallback implements Callback {
        private String username;

        @Override
        public String getPassword() {
            return null;
        }

        @Override
        public String getUsername() {
            return username;
        }

        public void setRequested(String username) {
            this.username = username;
        }
    }

    public static class PasswordCallback implements Callback {
        private String password;

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return null;
        }

        public void setRequested(String password) {
            this.password = password;
        }
    }
}