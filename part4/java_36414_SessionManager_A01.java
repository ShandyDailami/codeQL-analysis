import javax.security.auth.Subject;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.Guard;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class java_36414_SessionManager_A01 implements AccessControl {

    private List<String> permittedPrincipals = new ArrayList<>();

    public java_36414_SessionManager_A01(List<String> permittedPrincipals) {
        this.permittedPrincipals = permittedPrincipals;
    }

    @Override
    public boolean checkPermission(Permission permission) {
        return permittedPrincipals.contains(permission.getClass().getName());
    }

    @Override
    public boolean implies(Subject subject, Object permissions) {
        if (permissions instanceof List) {
            for (Permission permission : (List) permissions) {
                if (!checkPermission(permission)) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class SecureSessionManager {

    private final AccessControl accessControl;

    public java_36414_SessionManager_A01(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public void startSession(Principal principal) {
        if (accessControl.implies(principal, "startSession")) {
            // Session start code here
        } else {
            throw new SecurityException("Unauthorized attempt to start session");
        }
    }

    public void stopSession(Principal principal) {
        if (accessControl.implies(principal, "stopSession")) {
            // Session stop code here
        } else {
            throw new SecurityException("Unauthorized attempt to stop session");
        }
    }
}