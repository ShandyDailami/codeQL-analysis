import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_29112_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate( javax.security.auth.Credential credential ) throws CredentialException, InvalidCredentialException {
        // Simulate validation by returning true if the credential is not null and not empty
        if (credential == null || credential.getCredential() == null || credential.getCredential().isEmpty()) {
            throw new InvalidCredentialException("Invalid credentials");
        }
        return true;
    }
}