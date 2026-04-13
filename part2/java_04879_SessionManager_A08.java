import java.security.AccessControlException;
import java.security.Guard;
import java.security.Permission;
import java.security.Policy;
import java.util.HashSet;
import java.util.Set;

public class java_04879_SessionManager_A08 implements SecurityManager {

    private Set<String> permittedActions;

    public java_04879_SessionManager_A08() {
        permittedActions = new HashSet<>();
        permittedActions.add("read");
        permittedActions.add("write");
        permittedActions.add("delete");
    }

    @Override
    public void checkPermission(Permission perm) throws AccessControlException {
        // Not implemented in this example
    }

    @Override
    public void checkPermission(Permission perm, Object context) throws AccessControlException {
        // Not implemented in this example
    }

    @Override
    public boolean implies(SecurityManager sm) {
        // Not implemented in this example
        return false;
    }

    public void setPermittedActions(Set<String> permittedActions) {
        this.permittedActions = permittedActions;
    }

    public boolean checkActionPermission(String action) {
        return permittedActions.contains(action);
    }
}

public class SessionManager {

    private SecurityManager securityManager;

    public java_04879_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void performAction(String action) {
        if (securityManager.checkActionPermission(action)) {
            System.out.println("Permission granted for action: " + action);
        } else {
            System.out.println("Permission denied for action: " + action);
        }
    }
}