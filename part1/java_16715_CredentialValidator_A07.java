import javax.security.auth.Credential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamePasswordAuthentication;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.Guard;
import java.util.Arrays;
import java.util.List;

public class java_16715_CredentialValidator_A07 implements LoginModule {

    private Credential credential;
    private boolean authenticated;

    @Override
    public void initialize(Attributes attributes, AccessControlContext context, CallbackHandler callbackHandler) throws IOException, UnsupportedCallbackException {
        // Initialize the credential
        String username = attributes.getRequiredAttribute("username");
        String password = attributes.getRequiredAttribute("password");
        this.credential = new UsernamePasswordCredential(username, password.toCharArray());

        // CallbackHandler for username and password
        callbackHandler.handle(new Callback[]{new UsernamePasswordCallback(username)});
    }

    @Override
    public boolean authenticate(String username, String password) {
        if (this.credential != null && this.credential.getPassword().equals(password)) {
            this.authenticated = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean commit() {
        return this.authenticated;
    }

    @Override
    public void abort(CallbackHandler callbackHandler) {
        // Do nothing
    }

    @Override
    public boolean getRequestedAuthenticationKinds() {
        return AccessControlContext.SUCCESSFUL_LOGIN_KIND;
    }

    @Override
    public List<Guard> getGuards() {
        return Arrays.asList(new Guard[]{new UsernamePasswordGuard()});
    }

    private static class UsernamePasswordCallback implements Callback {
        private String username;

        public java_16715_CredentialValidator_A07(String username) {
            this.username = username;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof UsernamePasswordCallback) {
                return this.username.equals(((UsernamePasswordCallback) obj).username);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.username.hashCode();
        }

        @Override
        public String getRequestingPrincipal() {
            return this.username;
        }

        @Override
        public String getRequestorPrincipal() {
            return null;
        }

        @Override
        public void validate(Action[] actions) {
            // Do nothing
        }
    }
}