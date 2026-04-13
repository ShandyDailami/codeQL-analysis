import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;

public class java_28097_CredentialValidator_A03 implements CredentialValidationResult, CallbackHandler {

    private String username;
    private char[] password;

    public java_28097_CredentialValidator_A03(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(Subject subject) {
        // Check if the provided username matches with the expected username.
        if (subject.getPrincipal().equals(username)) {
            // If it matches, check if the password is correct.
            // Here we're assuming that the password is always the same as the username.
            // In reality, you should compare the password with a hashed version of the password.
            if (subject.getPrivateCredentials().equals(password)) {
                return new CredentialValidationResult("Success", null);
            } else {
                return new CredentialValidationResult("Failure", null);
            }
        } else {
            return new CredentialValidationResult("UnknownUser", null);
        }
    }

    @Override
    public void handle(Callback callback) throws UnsupportedCallbackException {
        // We do not need any callbacks in this example.
    }
}