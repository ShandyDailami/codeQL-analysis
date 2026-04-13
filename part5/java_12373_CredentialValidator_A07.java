import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.security.auth.Subject;
import java.security.auth.callback.CallbackHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class java_12373_CredentialValidator_A07 implements CallbackHandler {

    private Set<String> acceptedActions = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("login")));

    @Override
    public boolean checkCallback(Callback[] callbacks) throws IOException, LoginException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernameCallback) {
                UsernameCallback cb = (UsernameCallback) callback;
                cb.setRequested(true);
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback cb = (PasswordCallback) callback;
                cb.setRequested(true);
            }
        }
        return true;
    }

    @Override
    public Subject authenticate(Subject subject, String target, CallbackHandler callbackHandler, Map<String, Object> properties) throws IOException, LoginException, UnsupportedCallbackException {
        return subject;
    }
}

class UsernameCallback implements Callback {
    public String username = null;
    public boolean requested = false;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isRequested() {
        return requested;
    }

    public void setRequested(boolean requested) {
        this.requested = requested;
    }

    @Override
    public void setRequested(boolean requested) {
        setRequested(requested);
    }
}

class PasswordCallback implements Callback {
    public String password = null;
    public boolean requested = false;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRequested() {
        return requested;
    }

    public void setRequested(boolean requested) {
        this.requested = requested;
    }

    @Override
    public void setRequested(boolean requested) {
        setRequested(requested);
    }
}