import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_00431_CredentialValidator_A03 implements CallbackHandler {

    private String userName;
    private String password;

    public java_00431_CredentialValidator_A03(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler)
            throws LoginException, UnsupportedCallbackException {

        CredentialValidationResult result = null;

        UsernamePasswordCredential credential = new UsernamePasswordCredential(userName, password);

        // Verify user credentials
        if (credential.getPassword() != null
                && credential.getPassword().equals(userName)) {
            result = new CredentialValidationResult("Success", null, null);
        } else {
            result = new CredentialValidationResult("Failure", null, null);
        }

        return result;
    }
}