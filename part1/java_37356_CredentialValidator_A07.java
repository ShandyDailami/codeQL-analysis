import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_37356_CredentialValidator_A07 implements CredentialValidator {

    private String username;
    private char[] password;

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler)
            throws LoginException {

        // Prompt the user for username and password
        UsernamePasswordCallbackHandler callback = new UsernamePasswordCallbackHandler();
        callbackHandler.handle(callback);

        // Store the username and password
        this.username = callback.getCallerPrincipal();
        this.password = callback.getPassword();

        // Check the username and password
        if (this.username != null && this.username.equals("myUsername")
                && new String(this.password).equals("myPassword")) {
            return true;
        } else {
            return false;
        }
    }
}