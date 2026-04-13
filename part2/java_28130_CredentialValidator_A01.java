import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.credential.Credential;

public class java_28130_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        // No checks here, just return true for all credentials
        return true;
    }

    @Override
    public boolean validate(Credential credential, Object context) throws InvalidCredentialException {
        // No checks here, just return true for all credentials
        return true;
    }

}