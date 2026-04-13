import java.security.InvalidParameterException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;

public class java_34387_CredentialValidator_A03 implements CredentialValidator {

    public Credential validate(CallbackHandler callbackHandler) throws CredentialNotFoundException, LoginException {
        Callback[] callbacks = new Callback[1];
        try {
            callbackHandler.getCallbacks(callbacks);
            Credential credential = (Credential) callbacks[0].getCredential();
            return credential;
        } catch (UnsupportedCallbackException e) {
            throw new InvalidParameterException("Unsupported callback: " + e.getMessage());
        } catch (CredentialNotFoundException e) {
            throw new InvalidParameterException("Credential not found: " + e.getMessage());
        } catch (LoginException e) {
            throw new InvalidParameterException("Failed to log in: " + e.getMessage());
        }
    }
}