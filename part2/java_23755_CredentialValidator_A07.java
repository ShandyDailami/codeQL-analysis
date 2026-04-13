import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamepassword.UsernamePasswordCallbackHandler;

public class java_23755_CredentialValidator_A07 implements CallbackHandler {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler) {
        Callback callback = new UsernamePasswordCallback("username", "password");
        try {
            callbackHandler.handle(callback);
            String providedUsername = callback.getIdentifier();
            String providedPassword = callback.getPassword();

            if (USERNAME.equals(providedUsername) && PASSWORD.equals(providedPassword)) {
                return new CredentialValidationResult("Success", null);
            } else {
                return new CredentialValidationResult("Failure", null);
            }
        } catch (UnsupportedCallbackException e) {
            throw new RuntimeException(e);
        }
    }
}