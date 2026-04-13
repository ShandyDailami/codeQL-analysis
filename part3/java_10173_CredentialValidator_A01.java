import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.CallerCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

public class java_10173_CredentialValidator_A01 implements javax.security.auth.credential.CredentialValidator {

    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password";

    @Override
    public CredentialValidationResult validate(CallerCallback callback) throws CredentialNotFoundException, LoginException, UnsupportedCallbackException {
        String username = callback.getRequest().getCredentials()[0].toString();
        String password = callback.getRequest().getCredentials()[1].toString();

        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }
}