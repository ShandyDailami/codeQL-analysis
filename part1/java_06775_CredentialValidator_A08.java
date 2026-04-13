import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessControlException;
import java.util.HashSet;
import java.util.Set;

public class java_06775_CredentialValidator_A08 {

    private Set<AccessControl> accessControls;

    public java_06775_CredentialValidator_A08() {
        accessControls = new HashSet<>();
    }

    public void addAccessControl(AccessControl accessControl) {
        accessControls.add(accessControl);
    }

    public boolean validate(Credential credential) {
        AccessControlContext context = new AccessControlContext(accessControls);
        try {
            context.getSubject().login(credential);
            return true;
        } catch (AccessControlException e) {
            return false;
        }
    }
}