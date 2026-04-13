import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.CallerCallback;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

public class java_22407_CredentialValidator_A07 implements CredentialValidator {

    private static final String USER = "admin";
    private static final String PASSWORD = "password";

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws LoginException {
        Callback callback = new Callback() {
            public void handle(String challenge) throws LoginException, IllegalArgumentException {
                if (!USER.equals(challenge)) {
                    throw new IllegalArgumentException("Invalid username: " + challenge);
                }
            }
        };

        callbackHandler.handle(callback);

        String password = null;
        try {
            password = callback.getPassword();
        } catch (Exception e) {
            throw new LoginException("Error getting password");
        }

        if (!PASSWORD.equals(password)) {
            throw new LoginException("Invalid password");
        }

        return new CredentialValidationResult("Success", null);
    }

}