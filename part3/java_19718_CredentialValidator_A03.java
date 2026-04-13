import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernamePasswordCredential;

public class java_19718_CredentialValidator_A03 implements CredentialValidator {

    // Define the hardcoded password
    private final String hardcodedPassword = "password";

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        // Check if the provided password matches the hardcoded password
        if (credential.getPassword().equals(hardcodedPassword)) {
            return credential;
        } else {
            throw new InvalidCredentialException("Invalid password");
        }
    }
}