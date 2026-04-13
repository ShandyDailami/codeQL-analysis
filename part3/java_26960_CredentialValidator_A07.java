import javax.security.auth.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.CredentialValidationResult;
import javax.security.auth.credential.UsernamePasswordCredentials;

public class java_26960_CredentialValidator_A07 implements CallbackHandler {
    private String username;
    private String password;

    public java_26960_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler)
            throws LoginException, UnsupportedCallbackException {
        Credential credential = new UsernamePasswordCredentials(username, password);
        return callbackHandler.getAuthenticationCredential(credential, callbackHandler);
    }

    public static void main(String[] args) throws Exception {
        CredentialValidator validator = new CredentialValidator("user", "password");
        CredentialValidationResult result = validator.validate(validator);
        if (result.isValid()) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}