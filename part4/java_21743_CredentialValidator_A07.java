import javax.security.auth.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.LoginModule;

public class java_21743_CredentialValidator_A07 implements LoginModule {

    private String username;
    private String password;

    @Override
    public void initialize(final javax.security.auth.Attributes attributes) {
        // not used in this example
    }

    @Override
    public boolean supports(final String authenticationSpec) {
        return authenticationSpec.equals("USERNAME_PASSWORD_TUTORIAL");
    }

    @Override
    public CredentialValidationResult validate(final CallbackHandler callbackHandler)
            throws LoginException, UnsupportedCallbackException {
        Credential credential = null;
        final Callback[] callbacks = new Callback[1];

        // get password and username from callbackHandler
        callbackHandler.getCallbacks(callbacks);
        Credential cred = callbacks[0];
        cred.setName("Username");
        cred.setString(callbacks[0].getClass().getName(), "John");
        callbacks[0].setPassword("Password123!");

        // compare the provided password with the expected password
        if (cred.getPassword().equals("Password123!")) {
            return new CredentialValidationResult("Success", cred);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }
}