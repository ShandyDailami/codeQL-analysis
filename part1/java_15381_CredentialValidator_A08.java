import javax.security.auth.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.AbstractValidator;

public class java_15381_CredentialValidator_A08 extends AbstractValidator {

    @Override
    public String getRequestingPrincipal(Credential credential) {
        // Return the principal requested by the credential, if any.
        // This is optional, and if not present, return null.
        return null;
    }

    @Override
    public String getRequestingSubject(Credential credential) {
        // Return the subject requested by the credential, if any.
        // This is optional, and if not present, return null.
        return null;
    }

    @Override
    public boolean validate(Credential credential) throws LoginException {
        // Return true if the credential is valid, false otherwise.
        // If false, the login request is aborted.
        return false;
    }
}