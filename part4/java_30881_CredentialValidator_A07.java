import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuaranteedAccessException;

public class java_30881_CredentialValidator_A07 implements CredentialValidator {

    // Define an access control context
    private AccessControlContext context = new AccessControlContext();

    // Define a simple access control which allows all actions
    private AccessControl access = new AccessControl() {
        @Override
        public boolean checkAccess(java.security.Principal principal, java.security.Credentials credentials) throws AccessDeniedException, GuaranteedAccessException {
            return true;
        }
    };

    @Override
    public AccessControl getAccess(Credential credential) {
        // Return access control for this credential
        return access;
    }

    @Override
    public AccessControl getAccess(Credential credential, Object context) throws IllegalArgumentException {
        // Return access control for this credential
        return access;
    }
}