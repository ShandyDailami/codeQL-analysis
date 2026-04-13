import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_22743_CredentialValidator_A08 implements LoginModule {
    private String username;
    private char[] password;

    public java_22743_CredentialValidator_A08(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, String username, char[] password)
            throws LoginException, UnsupportedCallbackException {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean supports(String authenticationId) {
        return authenticationId != null && authenticationId.equals("custom");
    }

    @Override
    public boolean commit() throws LoginException {
        // Integrity check logic here
        // For simplicity, let's assume that the username and password match
        if (this.username != null && this.username.equals("admin") && this.password != null && this.password.equals("password")) {
            return true;
        }

        throw new LoginException("Authentication failed");
    }

    @Override
    public boolean upgrade() throws LoginException {
        return false;
    }
}