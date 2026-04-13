import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardianObject;
import java.security.GuardianSet;
import java.util.HashSet;
import java.util.Set;

public class java_01331_CredentialValidator_A01 implements LoginModule {

    private AccessControlContext context;
    private Subject subject;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           AccessControl accessControl) throws LoginException {
        this.subject = subject;
        this.context = (AccessControlContext) accessControl;
        if (callbackHandler != null) {
            callbackHandler.handle(new Callback[]{new UsernamePasswordCallback("admin", "password".toCharArray())});
        }
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public boolean abort(Subject subject, String action, Throwable previous) throws LoginException {
        return true;
    }

    @Override
    public boolean log(String message, Throwable t) {
        return false;
    }

    @Override
    public Set<GuardianSet> getGuardianSets() {
        return new HashSet<>();
    }

    public static class UsernamePasswordCallback implements Callback {

        private String username;
        private char[] password;

        public java_01331_CredentialValidator_A01(String username, char[] password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public boolean handle(Callback callback) throws UnsupportedCallbackException {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback cb = (UsernamePasswordCallback) callback;
                cb.setUsername(username);
                cb.setPassword(password);
                return true;
            }
            return false;
        }

        @Override
        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public void setPassword(char[] password) {
            this.password = password;
        }
    }
}