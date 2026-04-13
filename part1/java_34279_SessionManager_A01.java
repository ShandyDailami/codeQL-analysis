import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_34279_SessionManager_A01 implements SecurityManager {
    private boolean isBroken;

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    @Override
    public boolean checkPermission(Permission p) {
        if (isBroken) {
            throw new SecurityException("Permission " + p.getName() + " denied");
        }
        return !isBroken;
    }

    @Override
    public boolean checkPermission(Permission p, Object constraint) {
        if (isBroken) {
            throw new SecurityException("Permission " + p.getName() + " denied");
        }
        return !isBroken;
    }

    @Override
    public <T> T invoke(PrivilegedAction<T> action) {
        if (isBroken) {
            throw new SecurityException("Access denied");
        }
        return action.run();
    }

    public static void main(String[] args) {
        CustomSecurityManager securityManager = new CustomSecurityManager();
        securityManager.setBroken(true);
        SecurityManager old = System.getSecurityManager();
        System.setSecurityManager(securityManager);
        System.out.println("Accessing resource...");
        System.getSecurityManager().checkPermission(new java.security.Permission("access"));
        System.setSecurityManager(old);
    }
}