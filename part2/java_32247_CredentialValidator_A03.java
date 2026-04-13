import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;
import javax.security.auth.Subject;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.GuardedObjectArray;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_32247_CredentialValidator_A03 implements CredentialValidator {

    private static final Set<String> AUTHORIZED_USERS = new HashSet<>(Arrays.asList("user1", "user2", "user3"));
    private static final Set<String> AUTHORIZED_PASSWORDS = new HashSet<>(Arrays.asList("pass1", "pass2", "pass3"));

    @Override
    public CredentialValidationResult validate(Credential credential) throws CredentialException {
        String user = credential.getIdentifier();
        String password = credential.getCredentialIdentifier();

        if (AUTHORIZED_USERS.contains(user) && AUTHORIZED_PASSWORDS.contains(password)) {
            return CredentialValidationResult.VALID;
        } else {
            return CredentialValidationResult.INVALID;
        }
    }

    @Override
    public boolean getAccessGroup(AccessControlContext context, String action, Object identity, GuardedObjectArray attributes) throws CredentialException {
        // This method is not used in this example, but it's required by the interface
        return false;
    }
}