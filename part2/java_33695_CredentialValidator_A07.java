import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.AuthenticationException;

public class java_33695_CredentialValidator_A07 implements CredentialValidator {

    private String expectedUsername;
    private String expectedPassword;

    public java_33695_CredentialValidator_A07(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler, Callback[] callbacks) throws AuthenticationException, UnsupportedCallbackException {
        CredentialID credentialID = new CredentialID();
        credentialID.getPassword();

        if (expectedUsername.equals(credentialID.getIdentifier()) && expectedPassword.equals(credentialID.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}