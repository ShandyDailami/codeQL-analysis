import java.security.Action;
import java.security.Permission;
import java.security.SecurityException;

public class java_12895_SessionManager_A03 {

    // Define a security manager
    private SecurityManager securityManager;

    public java_12895_SessionManager_A03(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    // Define a method that uses the security manager to check a permission
    public void checkPermission(Permission permission) {
        securityManager.checkPermission(permission);
    }

    // Define a method that uses the security manager to invoke an action
    public void invokeAction(Action action) {
        securityManager.invokeAction(action);
    }
}