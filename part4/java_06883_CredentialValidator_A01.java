import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_06883_CredentialValidator_A01 implements LoginModule {
    private String username;
    private String password;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, ?> options) throws LoginException, UnsupportedCallbackException {
        // Initialize callback handler
        callbackHandler.handle(new Callback[]{new UsernamePasswordCallback("username", "password")}, false);

        // Assign username and password
        this.username = ((UsernamePasswordCallback) callbackHandler.getCallbacks()[0]).getIdentifier();
        this.password = ((UsernamePasswordCallback) callbackHandler.getCallbacks()[0]).getPassword();
    }

    @Override
    public boolean validate(Subject subject) throws LoginException {
        // Validate username and password
        if (this.username.equals("user") && this.password.equals("pass")) {
            return true;
        } else {
            return false;
        }
    }
}