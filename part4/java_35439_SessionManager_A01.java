import javax.security.auth.Subject;
import java.security.Guard;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;

public class java_35439_SessionManager_A01 extends java.security.SecurityManager {

    private Subject subject;

    public java_35439_SessionManager_A01(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void checkPermission(Permission permission) {
        // Your code here
    }

    @Override
    public void checkPermission(Permission permission, Object target) {
        // Your code here
    }

    @Override
    public void checkAction(String action) {
        // Your code here
    }

    @Override
    public void checkPermission(Permission permission, Object target, String targetString) {
        // Your code here
    }

    @Override
    public PermissionCollection getPermissions(ProtectionDomain domain) {
        return null;
    }

    @Override
    public Guard getGuard(Subject subject, ProtectionDomain domain) {
        return null;
    }

    @Override
    public Subject getSubject(Subject subject, ProtectionDomain domain) {
        return null;
    }

    @Override
    public void refresh() {
        // Your code here
    }
}