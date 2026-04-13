import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.CredentialException;

public class java_38484_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler) throws CredentialException {
        // Get credentials
        UsernamePasswordCallbackHandler callback = new UsernamePasswordCallbackHandler();
        callbackHandler.getCallbacks(callback);

        // Validate username and password
        String username = callback.getUsername();
        String password = callback.getPassword();

        if ("user".equals(username) && "password".equals(password)) {
            return true;
        } else {
            throw new CredentialException("Invalid username or password.");
        }
    }
}