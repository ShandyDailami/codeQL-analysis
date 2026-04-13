import java.security.GeneralSecurityException;
import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.security.credential.CredentialValidationResult;
import java.util.Arrays;
import java.util.Set;

public class java_18910_CredentialValidator_A01 implements CredentialValidator {
    // Set of allowed usernames.
    private static final Set<String> ALLOWED_USERNAMES = Arrays.asList("user1", "user2", "user3");

    @Override
    public CredentialValidationResult validate(Credential credential) throws GeneralSecurityException {
        CredentialSubject subject = (CredentialSubject) credential.getCredentialSubject();

        if (ALLOWED_USERNAMES.contains(subject.getIdentifier())) {
            return CredentialValidationResult.VALID;
        } else {
            return CredentialValidationResult.INVALID;
        }
    }
}