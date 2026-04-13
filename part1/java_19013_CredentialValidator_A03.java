import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_19013_CredentialValidator_A03 implements LoginModule {
    private String username;
    private char[] password;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, String authenticationId)
            throws LoginException, UnsupportedCallbackException {
        // No need to initialize anything in this case
    }

    @Override
    public boolean supports(String authenticationId) {
        return authenticationId != null;
    }

    @Override
    public boolean validate(Subject subject, String username, String password) {
        this.username = username;
        this.password = password.toCharArray();
        // Here you would typically perform a security-sensitive operation
        // For instance, you can check if the username is in a list of known good usernames
        // And if the password is a valid hash of the password
        return true;
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }
}