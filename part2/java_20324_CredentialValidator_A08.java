import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.UsernamePasswordCredential;

public class java_20324_CredentialValidator_A08 implements CredentialValidator {

    // Hardcoded username and password for testing
    private static final String USERNAME = "testUser";
    private static final String PASSWORD = "testPassword";

    @Override
    public CredentialValidatorResult validate(UsernamePasswordCredential credential) {
        if (credential.getUsername().equals(USERNAME) && credential.getPassword().equals(PASSWORD)) {
            return CredentialValidatorResult.VALID;
        } else {
            return CredentialValidatorResult.INVALID;
        }
    }
}