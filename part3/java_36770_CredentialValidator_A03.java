import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.Service;
import javax.security.auth.spi.ServiceDelegation;

public class java_36770_CredentialValidator_A03 implements Service, CallbackHandler {
    private String username;
    private String password;

    public CredentialValidationResult validate(CallbackHandler callbackHandler)
            throws LoginException, UnsupportedCallbackException {
        Callback[] callbacks = new Callback[1];
        callbacks[0] = new UsernamePasswordCallback("", true);

        callbackHandler.handle(callbacks);

        username = callbacks[0].getUsername();
        password = callbacks[0].getPassword();

        // validate the credentials here. For now, just check if they are null.
        if (username == null || password == null) {
            throw new LoginException("Authentication failed: Username or password is null.");
        }

        // You can also use a real database or other security service to validate the username and password.
        // Here, we just check if they are the same as expected.
        if (!username.equals("admin") || !password.equals("password")) {
            throw new LoginException("Authentication failed: invalid username or password.");
        }

        // If everything is fine, return a successful result.
        return new CredentialValidationResult("Success", null);
    }

    public ServiceDelegation getDelegate() {
        return null;
    }

    private static class UsernamePasswordCallback implements Callback {
        private String username;
        private boolean ok;

        public java_36770_CredentialValidator_A03(String username, boolean ok) {
            this.username = username;
            this.ok = ok;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return ok ? new String(username.getBytes()) : null;
        }

        public boolean setUsernamePassword(String s) {
            throw new UnsupportedOperationException();
        }

        public String getPasswordInfo() {
            throw new UnsupportedOperationException();
        }
    }
}