import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_40875_SessionManager_A08 {
    private SecurityManager securityManager;

    public java_40875_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public boolean checkAccess(Permission perm) {
        return securityManager.checkPermission(perm);
    }

    public <T> T invokePrivileged(PrivilegedAction<T> action) {
        return securityManager.invokePrivileged(action);
    }
}