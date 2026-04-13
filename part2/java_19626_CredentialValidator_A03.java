import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_19626_CredentialValidator_A03 implements LoginModule {
    private String username;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
            Map<String, ?> sharedState) throws LoginException, UnsupportedCallbackException {
        // No initialization needed for our module
    }

    @Override
    public boolean login() throws LoginException {
        // Assume we have a method to retrieve the username
        this.username = retrieveUsername();
        // Return true if the username contains a specific string
        return username.contains("bad_string");
    }

    @Override
    public boolean commit() throws LoginException {
        // No commit necessary here
        return false;
    }

    @Override
    public void logout() {
        // No logout necessary here
    }

    private String retrieveUsername() {
        // Implementation of retrieving the username from a secure source
        // For example, if we're using a database, we would query a user table
        return "good_username";
    }
}