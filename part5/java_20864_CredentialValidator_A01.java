import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_20864_CredentialValidator_A01 implements LoginModule {

    private String username;
    private String password;
    private Subject subject;

    @Override
    public void initialize(final CallbackHandler callbackHandler, final Subject subject)
            throws LoginException, UnsupportedCallbackException {
        this.subject = subject;
        final Callback[] callbacks = new Callback[1];
        callbackHandler.handle(callbacks);
        this.username = callbacks[0].getUsername();
        this.password = (String) callbacks[0].getPassword();
    }

    @Override
    public boolean validate() {
        // In this example, we're just validating if the username and password matches
        // A real application would need to check against a real database or security service
        if (this.username != null && this.username.equals("admin") && this.password != null && this.password.equals("password")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean commit() throws LoginException {
        // In this example, if the validation succeeds, the module is committed
        return validate();
    }

    @Override
    public void cleanup() {
        // Cleanup is not needed for this example
    }

}