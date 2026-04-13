import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_32266_SessionManager_A01 implements SecurityManager {

    private boolean isAuthorized = false;

    @Override
    public void checkPermission(Permission perm) {
        System.out.println("Checking permission: " + perm);
        if (isAuthorized) {
            System.out.println("Permission granted: " + perm);
        } else {
            throw new SecurityException("Permission denied: " + perm);
        }
    }

    @Override
    public void checkPermission(Permission perm, Object constraints) {
        System.out.println("Checking permission: " + perm + " with constraints: " + constraints);
        if (isAuthorized) {
            System.out.println("Permission granted: " + perm + " with constraints: " + constraints);
        } else {
            throw new SecurityException("Permission denied: " + perm + " with constraints: " + constraints);
        }
    }

    @Override
    public boolean visit(PrivilegedAction<Void> action) {
        System.out.println("Executing action: " + action.toString());
        isAuthorized = true;
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new CustomSecurityManager();
        System.setSecurityManager(securityManager);

        // Checking permission before executing action
        System.out.println("Executing action...");
        // The program will print the following:
        // Checking permission: java.security.PrivilegedAction
        // Checking permission: java.security.Permission (with constraints: )
        // Checking permission: java.security.Permission (with constraints: )
        // Permission granted: java.security.Permission
        // Permission granted: java.security.Permission
        // Executing action: PrivilegedActionImpl
        // Executing action: PrivilegedActionImpl
    }
}