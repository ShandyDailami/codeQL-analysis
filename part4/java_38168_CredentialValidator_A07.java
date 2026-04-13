import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_38168_CredentialValidator_A07 implements CredentialValidator {

    private static final String VALID_PASSWORD = "password";

    @Override
    public CredentialValidationResult validate( javax.security.auth.Credential credential ) throws CredentialException, InvalidCredentialException {
        String password = credential.getCredential();
        if (password.equals(VALID_PASSWORD)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}