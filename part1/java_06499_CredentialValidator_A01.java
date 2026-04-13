import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_06499_CredentialValidator_A01 implements CallbackHandler {

    private Credential credential;

    @Override
    public Credential getCredential(CallbackHandler callbackHandler) throws UnsupportedCallbackException, LoginException {
        Callback[] callbacks = callbackHandler.getCallbacks();
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCredential) {
                UsernamePasswordCredential usernamePassword = (UsernamePasswordCredential) callback;
                this.credential = usernamePassword;
            }
        }
        return this.credential;
    }

    public static void main(String[] args) {
        CustomCredentialValidator customCredentialValidator = new CustomCredentialValidator();
        // Verify the credentials
        try {
            customCredentialValidator.getCredential(customCredentialValidator);
            System.out.println("Credentials Verified");
        } catch (Exception e) {
            System.out.println("Credentials Not Verified");
        }
    }
}