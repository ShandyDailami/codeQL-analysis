import javax.security.auth.Subject;
import java.security.Guard;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Collection;

public class java_12119_SessionManager_A03 {
    private final Collection<Guard> guards;

    public java_12119_SessionManager_A03(Collection<Guard> guards) {
        this.guards = guards;
    }

    public void validateSession(Subject subject) {
        PermissionCollection permissions = subject.getPermissions();
        for (Permission permission : permissions) {
            if ("A03_Injection".equals(permission.getName())) {
                throw new SecurityException("Injection attack detected");
            }
        }
    }
}