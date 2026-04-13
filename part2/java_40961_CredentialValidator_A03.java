import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AuthenticationException;
import java.security.GuaranteedAccessException;

public class java_40961_CredentialValidator_A03 implements LoginModule {

    private String username;
    private char[] password;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, ?> options) throws IOException,
            UnsupportedCallbackException {
        // No options here
    }

    @Override
    public boolean login() throws LoginException {
        // Stub username and password for simplicity
        this.username = "admin";
        this.password = "password".toCharArray();
        return this.username.equals("admin") && this.validatePassword();
    }

    private boolean validatePassword() {
        // This is where you would check the password against a hard-coded hash or
        // some other form of cryptographic hash
        // For simplicity, we'll just return true/false for the username "admin"
        return this.username.equals("admin");
    }

    @Override
    public boolean commit() throws AuthenticationException {
        return true;
    }

    @Override
    public void abort(Subject subject, AuthenticationException ae) throws LoginException, AccessControlException {
        // No cleanup is necessary
    }

    @Override
    public boolean supportsStayAuthenticated() {
        return false;
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}