import java.security.Action;
import java.security.Permission;
import java.security.SecurityException;

public class java_09301_SessionManager_A07 {
    private static SecureSessionManager instance = null;

    private java_09301_SessionManager_A07() {
    }

    public static SecureSessionManager getInstance() {
        if (instance == null) {
            instance = new SecureSessionManager();
        }
        return instance;
    }

    public void executeAction(Action action) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            // If no security manager, allow the action to proceed
            action.invoke();
        } else {
            // Otherwise, check the permission
            Permission permission = new Permission("SomeSecurityAction");
            try {
                securityManager.checkPermission(permission);
                action.invoke();
            } catch (SecurityException e) {
                System.out.println("Permission denied: " + e.getMessage());
            }
        }
    }
}