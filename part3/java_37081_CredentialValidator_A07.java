import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;

public class java_37081_CredentialValidator_A07 implements CredentialValidator {

    private Credential credential;

    public java_37081_CredentialValidator_A07(Credential credential) {
        this.credential = credential;
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws CredentialException, UnsupportedCallbackException {
        Callback[] callbacks = new Callback[1];
        callbacks[0] = new CredentialValidationResult(credential);
        callbackHandler.handle(callbacks);
        return callbacks[0];
    }
}