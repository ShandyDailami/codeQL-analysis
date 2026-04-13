import javax.security.auth.login.LoginException;
import javax.security.auth.logout.LogoutException;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;

public class java_13141_CredentialValidator_A01 implements CredentialValidator, CallbackHandler, Runnable {

    private String username;
    private String password;

    public java_13141_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(UsernamePasswordCredential credential) throws LoginException {
        String providedUsername = credential.getIdentifier();
        String providedPassword = credential.getPassword();

        if (username.equals(providedUsername) && password.equals(providedPassword)) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        // Not implemented in this example
        return null;
    }

    @Override
    public void run() {
        // Not implemented in this example
    }
}