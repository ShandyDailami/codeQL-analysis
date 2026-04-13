import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_28720_CredentialValidator_A03 implements CredentialValidator {

    // This validator only allows passwords with a length greater than 8.
    @Override
    public CredentialValidatorResult validate(javax.security.auth.Credential cred) throws CredentialException, InvalidCredentialException {
        String password = cred.getCredential();
        if (password.length() > 8) {
            return CredentialValidatorResult.VALID;
        } else {
            return CredentialValidatorResult.INVALID;
        }
    }
}