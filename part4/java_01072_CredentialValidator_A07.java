import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Base64;

public class java_01072_CredentialValidator_A07 implements CredentialValidator {

    private String hardCodedPassword;

    public java_01072_CredentialValidator_A07(String hardCodedPassword) {
        this.hardCodedPassword = hardCodedPassword;
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler, Map<String, Object> map) throws IOException, UnsupportedCallbackException {
        Callback[] callbacks = callbackHandler.getCallbacks();
        for (Callback callback : callbacks) {
            if (callback instanceof NameCallback) {
                NameCallback nameCallback = (NameCallback) callback;
                nameCallback.setRequestedName("password");
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback passwordCallback = (PasswordCallback) callback;
                String userPassword = passwordCallback.getPassword();
                return userPassword.equals(this.hardCodedPassword);
            }
        }
        return false;
    }
}