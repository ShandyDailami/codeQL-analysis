import javax.security.auth.Subject;
import java.security.Permission;
import java.security.SecurityPermission;

public class java_25994_SessionManager_A08 {

    private Subject currentUser;

    public java_25994_SessionManager_A08(Subject user) {
        this.currentUser = user;
    }

    public void doSecurityCheck(Permission permission) {
        if (currentUser.getPrincipal() == null) {
            throw new SecurityException("User not logged in");
        }
        if (!currentUser.getSubject().hasRole(permission)) {
            throw new SecurityException("Insufficient permissions");
        }
    }

    public void closeSession() {
        // Implementation depends on how sessions are managed. For instance, it could be a simple operation here.
        System.out.println("Session closed");
    }
}