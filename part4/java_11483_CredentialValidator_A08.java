import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;

public class java_11483_CredentialValidator_A08 implements CallbackHandler {

    private String hardcodedUsername = "admin";
    private String hardcodedPassword = "password";

    @Override
    public CredentialValidationResult validate(Callback[] callbacks) throws AuthenticationException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernameCallback) {
                UsernameCallback cc = (UsernameCallback) callback;
                if (!this.hardcodedUsername.equals(cc.getUsername())) {
                    throw new AuthenticationException("Invalid username or password");
                }
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback pcb = (PasswordCallback) callback;
                if (!this.hardcodedPassword.equals(pcb.getPassword())) {
                    throw new AuthenticationException("Invalid username or password");
                }
            }
        }
        return new CredentialValidationResult("Success", null);
    }
}