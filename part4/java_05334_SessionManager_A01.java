import java.security.Permission;
import java.security.SecurityManager;

public class java_05334_SessionManager_A01 {
    private static SessionManager instance;
    private SecurityManager securityManager;

    private java_05334_SessionManager_A01() {
        securityManager = System.getSecurityManager();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void openSession(String user) {
        if (securityManager != null) {
            Permission permission = new Permission("session creation", user);
            try {
                securityManager.checkPermission(permission);
            } catch (SecurityException e) {
                // handle permission denied
                System.out.println("Permission denied for user: " + user);
            }
        }
        // open session here...
    }

    public void closeSession(String user) {
        if (securityManager != null) {
            Permission permission = new Permission("session close", user);
            try {
                securityManager.checkPermission(permission);
            } catch (SecurityException e) {
                // handle permission denied
                System.out.println("Permission denied for user: " + user);
            }
        }
        // close session here...
    }

    public void updateSession(String user) {
        if (securityManager != null) {
            Permission permission = new Permission("session update", user);
            try {
                securityManager.checkPermission(permission);
            } catch (SecurityException e) {
                // handle permission denied
                System.out.println("Permission denied for user: " + user);
            }
        }
        // update session here...
    }
}