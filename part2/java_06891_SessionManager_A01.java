import java.security.Action;
import java.security.Permission;
import java.security.Policy;

public class java_06891_SessionManager_A01 extends SecurityManager {

    private boolean broken;

    public java_06891_SessionManager_A01(boolean broken) {
        this.broken = broken;
    }

    @Override
    public void checkPermission(Permission perm) {
        if (broken) {
            throw new SecurityException("Broken Permission: " + perm.getName());
        }
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        if (broken) {
            throw new SecurityException("Broken Permission: " + perm.getName());
        }
    }

    @Override
    public void checkActions(String actions[], Policy policy) {
        if (broken) {
            throw new SecurityException("Broken Actions: " + String.join(" ", actions));
        }
    }

    @Override
    public boolean implies(SecurityPermission perm) {
        if (broken) {
            throw new SecurityException("Broken Permission: " + perm.getName());
        }
        return false;
    }

    @Override
    public boolean implies(SecurityPermission perm, Object context) {
        if (broken) {
            throw new SecurityException("Broken Permission: " + perm.getName());
        }
        return false;
    }
}

public class SessionManager {

    private BrokenAccessSecurityManager securityManager;

    public java_06891_SessionManager_A01(BrokenAccessSecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void startSession() {
        try {
            securityManager.checkPermission("Start Session");
            System.out.println("Session started");
        } catch (SecurityException e) {
            System.out.println("Failed to start session: " + e.getMessage());
        }
    }

    public void endSession() {
        try {
            securityManager.checkPermission("End Session");
            System.out.println("Session ended");
        } catch (SecurityException e) {
            System.out.println("Failed to end session: " + e.getMessage());
        }
    }
}