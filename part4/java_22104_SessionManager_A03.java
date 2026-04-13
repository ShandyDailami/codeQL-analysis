import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_22104_SessionManager_A03 implements SecurityManager {

    private String user;

    public java_22104_SessionManager_A03(String user) {
        this.user = user;
    }

    @Override
    public String getClassPermission(Class<?> clazz) {
        return "link";
    }

    @Override
    public String getDeclaredPermission(String variable) {
        return "link";
    }

    @Override
    public String getElementPermission(String id) {
        return "link";
    }

    @Override
    public void checkPermission(Permission perm) {
        // Do nothing
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        // Do nothing
    }

    @Override
    public void checkExit(int status) {
        // Do nothing
    }

    @Override
    public <T> T invoke(PrivilegedAction<T> action) {
        // Only allow the user to access its own methods
        if (user.equals(Thread.currentThread().getContextClassLoader().getParent().getClass().getEnclosingMethod().getDeclaringClass().getName())) {
            return action.run();
        } else {
            throw new SecurityException("Permission Denied");
        }
    }

    @Override
    public void refresh() {
        // Do nothing
    }
}

public class SessionManager {

    private SecurityManager securityManager;

    public java_22104_SessionManager_A03(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void startSession(String user) {
        // Only allow the user to start a session
        if (user.equals(Thread.currentThread().getContextClassLoader().getParent().getClass().getEnclosingMethod().getDeclaringClass().getName())) {
            // Start session
        } else {
            throw new SecurityException("Permission Denied");
        }
    }

    public void closeSession() {
        // Only allow the user to close a session
        if (Thread.currentThread().getContextClassLoader().getParent().getClass().getEnclosingMethod().getDeclaringClass().getName().equals(Thread.currentThread().getContextClassLoader().getParent().getClass().getEnclosingMethod().getDeclaringClass().getName())) {
            // Close session
        } else {
            throw new SecurityException("Permission Denied");
        }
    }
}