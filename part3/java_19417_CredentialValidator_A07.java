import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_19417_CredentialValidator_A07 implements LoginModule {
    private String username = "admin";
    private String password = "password";

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, String arg2)
            throws LoginException, UnsupportedCallbackException {
        // Not needed for this example
    }

    @Override
    public boolean validate(Subject subject, String usernameToTest, String passwordToTest) {
        if (usernameToTest.equals(username) && passwordToTest.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}