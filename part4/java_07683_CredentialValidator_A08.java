import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;

public class java_07683_CredentialValidator_A08 implements LoginModule {

    private String username = null;
    private String password = null;
    private Subject subject = null;

    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, ?> properties) throws LoginException {
        this.subject = subject;
        Callback[] callbacks = new Callback[]{new UsernamePasswordCallback(subject)};
        callbackHandler.handle(callbacks);
    }

    public boolean commit() throws LoginException {
        username = subject.getPrincipal().toString();
        password = new String(Base64.getDecoder().decode(subject.getPrivateCredentials()[0].getPassword()));

        // TODO: Add your own logic for checking user credentials
        // For example, if username is "admin" and password is "password":
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean abort() throws LoginException {
        return true;
    }

    public String getIdentifier() {
        return "CustomLoginModule";
    }

    private static class UsernamePasswordCallback implements Callback {

        private String caller;

        public java_07683_CredentialValidator_A08(Subject subject) {
            caller = subject.getPrincipal().toString();
        }

        public String getPassword() {
            return caller;
        }

        public String getCaller() {
            return caller;
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            final UsernamePasswordCallback other = (UsernamePasswordCallback) obj;
            if ((this.caller == null) ? (other.caller != null) : !this.caller.equals(other.caller)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hash = 5;
            hash = 59 * hash + (this.caller != null ? this.caller.hashCode() : 0);
            return hash;
        }
    }
}