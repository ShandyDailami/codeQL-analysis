import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_24426_SessionManager_A07 implements SecurityManager {

    @Override
    public void checkPermission(Permission perm) {
        // Check permission is not implemented here
        // If permission is not granted, throw an exception
    }

    @Override
    public void checkPermissions(String... perms) {
        // Check multiple permissions is not implemented here
        // If any permission is not granted, throw an exception
    }

    @Override
    public boolean getDelegateNames(String className, String[] delegateNames, String[] signatures) {
        // Return false because this method is not needed in this example
        return false;
    }

    @Override
    public Object invoke(PrivilegedAction<?> action) {
        try {
            return action.run();
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static SecurityManager getInstance() {
        return new CustomSecurityManager();
    }
}

public class SessionManager {

    private SecurityManager securityManager;

    public java_24426_SessionManager_A07() {
        this.securityManager = new CustomSecurityManager();
    }

    public void startSession(String user) {
        securityManager.checkAccess(user);
        // Session is started
    }
}