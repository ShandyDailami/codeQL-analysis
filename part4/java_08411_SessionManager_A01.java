import java.security.Permission;
import java.security.SecurityManager;
import java.security.UnsufficientPermissionException;

public class java_08411_SessionManager_A01 {
    private SecurityManager securityManager;

    public java_08411_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void createSession() {
        if (securityManager != null) {
            Permission permission = new Permission("session.create");
            try {
                securityManager.checkPermission(permission);
                // Create session here
                System.out.println("Session created successfully");
            } catch (UnsufficientPermissionException e) {
                System.out.println("Permission Denied: " + e.getMessage());
            }
        } else {
            System.out.println("Security Manager is not set");
        }
    }
}