import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_24876_CredentialValidator_A03 implements LoginModule {

    private String username;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, ?> options) throws LoginException, UnsupportedCallbackException {
        // No setup for this module.
    }

    @Override
    public boolean login() throws LoginException {
        // Assume we're using a callback handler to get the username.
        CallbackHandler callbackHandler = new CallbackHandler() {
            @Override
            public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
                username = (String) callbacks[0].getCallback();
            }
        };

        // Callback mechanism to get the username.
        callbackHandler.handle(new Callback[] { new UsernameCallback("Please enter your username: ")});

        // Check the username.
        if (username == null || username.trim().isEmpty()) {
            throw new LoginException("Invalid username");
        }

        // Assume the username is valid.
        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public void cleanup() {
        // No cleanup necessary for this module.
    }

    // Inner class for username callback.
    private static class UsernameCallback implements Callback {

        private final String message;

        public java_24876_CredentialValidator_A03(String message) {
            this.message = message;
        }

        @Override
        public String getName() {
            return "Username";
        }

        @Override
        public String getCallerName() {
            return "Unknown";
        }

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public void setMessage(String message) {
            // No-op.
        }

        @Override
        public boolean needsRequest(String request) {
            return "Credentials".equals(request);
        }

        @Override
        public boolean prompt(String message) {
            return false;
        }
    }
}