import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.realm.Realm;
import javax.security.sasl.AuthenticationException;

public class java_06058_CredentialValidator_A07 implements CallbackHandler {
    private Realm realm;

    public java_06058_CredentialValidator_A07(Realm realm) {
        this.realm = realm;
    }

    @Override
    public CredentialValidationResult validate(Callback[] callbacks)
        throws UnsupportedCallbackException, AuthenticationException {

        // Assuming only two callbacks for usernames and passwords
        for (Callback callback : callbacks) {
            if (callback instanceof UsernameCallback) {
                UsernameCallback userCallback = (UsernameCallback) callback;
                userCallback.setRequestedPassword("");
                String username = userCallback.getRequestedPassword();

                if ("user".equals(username)) {
                    return CredentialValidationResult.success("User");
                } else {
                    return CredentialValidationResult.failure();
                }
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback passCallback = (PasswordCallback) callback;
                passCallback.setRequestedPassword("");
                String password = passCallback.getRequestedPassword();

                if ("password".equals(password)) {
                    return CredentialValidationResult.success("Password");
                } else {
                    return CredentialValidationResult.failure();
                }
            }
        }

        return CredentialValidationResult.failure();
    }
}