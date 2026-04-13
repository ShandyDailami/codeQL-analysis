import javax.security.auth.AuthenticationException;
import javax.security.auth.CredentialValidator;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_13952_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public String getRequestingService() {
        // return the name of the service that requires the credentials
        return "MyService";
    }

    @Override
    public void validate(CallbackHandler callbackHandler) throws AuthenticationException, java.io.IOException {
        // handle callbacks for authentication request
        Callback callback = callbackHandler.getCallback();
        callback.put(Callback.OUTPUT_STREAM, System.out);
        callback.put(Callback.OUTPUT_STREAM_OPTION, true);
        callbackHandler.done();
    }

    @Override
    public void validate(String s) throws AuthenticationException {
        // No need to validate against a specific user, just use this for requesting service
    }

    @Override
    public String getName() {
        // return the name of the validator
        return "MyValidator";
    }

    @Override
    public boolean validate(Credential credential) throws AuthenticationException {
        // check if the credential is correct, return true if correct
        return credential.getIdentifier().equals("username") && credential.getPassword().equals("password");
    }
}