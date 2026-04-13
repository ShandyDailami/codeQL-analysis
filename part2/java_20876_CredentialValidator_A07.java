import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernamePasswordCredential;

public class java_20876_CredentialValidator_A07 implements CredentialValidator {

    private final String ALLOWED_USERNAME = "admin";
    private final String ALLOWED_PASSWORD = "password";

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        if (credential.getIdentifier().equals(ALLOWED_USERNAME) && credential.getCredential().equals(ALLOWED_PASSWORD)) {
            return credential;
        } else {
            throw new InvalidCredentialException("Invalid credentials");
        }
    }
}