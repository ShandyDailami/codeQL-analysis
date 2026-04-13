import javax.security.auth.Credential;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.sasl.AuthenticationException;

public class java_35916_CredentialValidator_A08 implements CredentialValidator {

    private String username;
    private String password;

    public java_35916_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        String presentedPassword = credential.get Password();

        if (username.equals(credential.getIdentifier()) && password.equals(presentedPassword)) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }

    @Override
    public boolean validate(Subject subject, Credential credential, CallbackHandler callbackHandler) throws AuthenticationException {
        return false;
    }
}