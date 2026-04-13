import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_19009_CredentialValidator_A07 implements CredentialValidationResult.Status, CallbackHandler {

    // The list of allowed usernames and passwords
    private String[][] allowedCredentials = {
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"}
    };

    // The callback handler
    private final CallbackHandler handler;

    public java_19009_CredentialValidator_A07(CallbackHandler handler) {
        this.handler = handler;
    }

    @Override
    public CredentialValidationResult validate(Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
        // Get the credential from the callbacks
        Credential credential = (Credential) callbacks[0].getCredential();
        
        // Check the username and password
        for (String[] credentialInfo : allowedCredentials) {
            if (credentialInfo[0].equals(credential.getUsername()) && credentialInfo[1].equals(credential.getPassword())) {
                // If the credentials are in the allowed list, return a successful result
                return new CredentialValidationResult("Success", "A07_AuthFailure");
            }
        }

        // If the credentials are not in the allowed list, return a failure result
        return new CredentialValidationResult("Failure", "A07_AuthFailure");
    }
}