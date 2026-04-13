import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

public class java_39798_CredentialValidator_A03 implements CredentialValidator {

    private String username;
    private String password;

    public java_39798_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Subject getSubject(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        // This part is not related to injection attacks. It is just a placeholder.
        return null;
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws LoginException {
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new UsernamePasswordCallback("Username: ", true);
        callbacks[1] = new UsernamePasswordCallback("Password: ", true);

        try {
            callbackHandler.handle(callbacks);

            String enteredUsername = ((UsernamePasswordCallback) callbacks[0]).getPassword();
            String enteredPassword = ((UsernamePasswordCallback) callbacks[1]).getPassword();

            if (this.username.equals(enteredUsername) && this.password.equals(enteredPassword)) {
                return new CredentialValidationResult("Success");
            }
        } catch (Exception e) {
            throw new LoginException("Login failed");
        }

        return new CredentialValidationResult("Failure");
    }
}