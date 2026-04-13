import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_33924_CredentialValidator_A03 implements CallbackHandler {

    // This is a simple way of using a username and password
    private String validUsername = "user";
    private String validPassword = "password";

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        Credential credential = null;
        Callback callback = new UsernamePasswordCallback("Username:", "Password:");
        callbackHandler.handle(callback);

        String userName = callback.getRequestedId();
        String password = new String(callback.getPassword());

        if (userName != null && userName.equals(validUsername) && password != null && password.equals(validPassword)) {
            credential = new UsernamePasswordCredential(userName, password);
        } else {
            throw new LoginException("Invalid username or password");
        }

        return new CredentialValidationResult(credential, null);
    }
}