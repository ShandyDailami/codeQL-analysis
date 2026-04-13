import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_06597_CredentialValidator_A03 implements LoginModule {

    private String password;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, ?> options) throws LoginException, UnsupportedCallbackException {
        password = (String) options.get("password");
        if (password == null) {
            throw new LoginException("Password option not provided");
        }
    }

    @Override
    public boolean validate(Subject subject, String username,
                           CallbackHandler callbackHandler, Map<String, ?> options) throws LoginException, UnsupportedCallbackException {
        if (password != null) {
            String password = (String) callbackHandler.getCallback(new Callback[]{new UsernamePasswordCallback("password")}).getPassword();
            return password != null && this.password.equals(password);
        }
        return false;
    }

    private static class UsernamePasswordCallback implements Callback {
        private String username;

        public java_06597_CredentialValidator_A03(String username) {
            this.username = username;
        }

        @Override
        public Object getPassword() {
            return this.username;
        }

        @Override
        public String getRequestedUsername() {
            return this.username;
        }

        @Override
        public void putPassword(String password) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void putUsername(String username) {
            throw new UnsupportedOperationException();
        }
    }
}