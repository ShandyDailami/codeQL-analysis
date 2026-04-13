import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.username.UsernamePasswordAuthenticationMechanism;
import javax.security.auth.username.UsernamePasswordValidationResult;

public class java_22678_CredentialValidator_A03 implements UsernamePasswordAuthenticationMechanism {
    private String usernamePattern;

    public java_22678_CredentialValidator_A03(String usernamePattern) {
        this.usernamePattern = usernamePattern;
    }

    public UsernamePasswordValidationResult validate(Subject subject, String username, String password) {
        if (username.matches(this.usernamePattern)) {
            return UsernamePasswordValidationResult.success();
        } else {
            return UsernamePasswordValidationResult.failure();
        }
    }

    public void postLogin(Subject subject, String username, String password) {
        // No-op
    }

    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
                // No-op
            }
        };
    }
}