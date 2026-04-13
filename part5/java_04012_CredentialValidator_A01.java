import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernamePasswordCredential;

public class java_04012_CredentialValidator_A01 implements CredentialValidator {

    private final String VALID_USERNAME = "user";
    private final String VALID_PASSWORD = "pass";

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        if (credential.getIdentifier().equals(VALID_USERNAME) &&
            credential.getPassword().equals(VALID_PASSWORD)) {
            return null; // Successful authentication
        } else {
            throw new InvalidCredentialException("Invalid username or password"); // Authentication failure
        }
    }
}