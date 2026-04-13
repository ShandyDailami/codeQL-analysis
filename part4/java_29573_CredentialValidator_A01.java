import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;
import javax.security.auth.UsernamePasswordCredential;

public class java_29573_CredentialValidator_A01 implements CredentialValidator {

    // Overriding the isValid method
    @Override
    public CredentialValidationResult validate(Credential credential) throws LoginException {
        String password = credential.getPassword();
        if (password.equals("password")) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }
}