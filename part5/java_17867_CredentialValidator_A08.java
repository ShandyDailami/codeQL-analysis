import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;

public class java_17867_CredentialValidator_A08 implements CredentialValidator {
    private String expectedUsername;
    private String expectedPassword;

    public java_17867_CredentialValidator_A08(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    public Subject validate(CallbackHandler callbackHandler)
            throws IOException, AuthenticationException {
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new UsernamePasswordCallback("username", "password");
        callbacks[1] = new PasswordCallback("password", false);

        Subject subject = callbackHandler.handle(callbacks);

        if (subject == null) {
            throw new AuthenticationException("Invalid username or password");
        }

        return subject;
    }

    private class UsernamePasswordCallback extends UsernamePasswordCallback {
        public java_17867_CredentialValidator_A08(String name, String password) {
            super(name, password);
        }

        public String getPassword() {
            return this.password;
        }
    }

    private class PasswordCallback extends PasswordCallback {
        public java_17867_CredentialValidator_A08(String prompt) {
            super(prompt);
        }

        public String getPassword() {
            return this.password;
        }
    }
}