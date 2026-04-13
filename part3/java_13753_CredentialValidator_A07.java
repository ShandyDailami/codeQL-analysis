import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;

public class java_13753_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(Credential credential) throws InvalidCredentialException {
        if ("admin".equals(credential.getIdentifier()) && "password".equals(credential.getCredential())) {
            return CredentialValidatorResult.VALID;
        } else {
            return CredentialValidatorResult.INVALID;
        }
    }
}