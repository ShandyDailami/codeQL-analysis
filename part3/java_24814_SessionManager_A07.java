import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_24814_SessionManager_A07 {

    private SecurityManager securityManager;

    public java_24814_SessionManager_A07(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public String getUserName() {
        return securityManager.doPrivileged(new PrivilegedAction<String>() {
            public String run() {
                return (String) securityManager.getSubject().getPrincipal();
            }
        });
    }

    public void checkPermission(Permission permission) {
        securityManager.checkPermission(permission);
    }

    public void checkActions(String actions) {
        securityManager.checkActions(actions.split(" "));
    }
}