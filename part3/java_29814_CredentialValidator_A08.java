import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialNotFoundException;
import javax.security.auth.credential.CredentialValidator;
import javax.security.auth.credential.InvalidCredentialException;

public class java_29814_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public Credential validate(Credential credential) throws CredentialNotFoundException, InvalidCredentialException {
        if (credential == null) {
            throw new CredentialNotFoundException("Credential not found");
        } else if (!(credential instanceof UsernamePasswordCredential)) {
            throw new InvalidCredentialException("Invalid credential type");
        } else {
            return credential;
        }
    }
}