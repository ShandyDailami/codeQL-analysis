import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.Guard;
import java.security.Guardian;
import java.security.GuardianBrokenException;
import java.security.GuardianNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class java_37028_CredentialValidator_A08 implements LoginModule {

    private String username;
    private String password;

    public java_37028_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate(CallbackHandler handler) throws LoginException, UnsupportedCallbackException {
        List<Callback> callbacks = new ArrayList<>();
        callbacks.add(new UsernameCallback(this.username));
        callbacks.add(new PasswordCallback(this.password, false));
        CredentialValidationResult result = handler.validate(callbacks.toArray(new Callback[callbacks.size()]));
        return result.isValid();
    }

    private class UsernameCallback implements Callback {

        private String username;

        public java_37028_CredentialValidator_A08(String username) {
            this.username = username;
        }

        @Override
        public void validate(Callback[] callbacks) throws UnsupportedCallbackException {
            for (Callback callback : callbacks) {
                if (callback instanceof UsernameCallback) {
                    ((UsernameCallback) callback).setUsername(this.username);
                } else {
                    throw new UnsupportedCallbackException(callback, "Invalid callback");
                }
            }
        }

        private void setUsername(String username) {
            this.username = username;
        }

    }

    private class PasswordCallback implements Callback {

        private String password;
        private boolean userPasswordAllowed;

        public java_37028_CredentialValidator_A08(String password, boolean userPasswordAllowed) {
            this.password = password;
            this.userPasswordAllowed = userPasswordAllowed;
        }

        @Override
        public void validate(Callback[] callbacks) throws UnsupportedCallbackException {
            for (Callback callback : callbacks) {
                if (callback instanceof PasswordCallback) {
                    ((PasswordCallback) callback).setPassword(this.password);
                    ((PasswordCallback) callback).setUserPasswordAllowed(this.userPasswordAllowed);
                } else {
                    throw new UnsupportedCallbackException(callback, "Invalid callback");
                }
            }
        }

        private void setPassword(String password) {
            this.password = password;
        }

        private void setUserPasswordAllowed(boolean userPasswordAllowed) {
            this.userPasswordAllowed = userPasswordAllowed;
        }

    }

}