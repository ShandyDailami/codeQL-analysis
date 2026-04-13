import java.security.Permission;
import java.security.SecurityManager;
import java.security.Guard;

public class java_29127_SessionManager_A03 implements SecurityManager {

    private static final long serialVersionUID = 1L;

    private Guard guard;

    public java_29127_SessionManager_A03(Guard guard) {
        this.guard = guard;
    }

    public void checkPermission(Permission perm) {
        if (!guard.checkPermission(perm)) {
            throw new SecurityException("Permission denied: " + perm);
        }
    }

    public void checkActions(String actions) {
        if (!guard.checkActions(actions.split(" "))) {
            throw new SecurityException("Action not allowed: " + actions);
        }
    }

    public void checkAccess(String actions) {
        if (!guard.checkAccess(actions.split(" "))) {
            throw new SecurityException("Access denied: " + actions);
        }
    }
}