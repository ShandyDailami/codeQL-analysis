import java.lang.reflect.InvocationTargetException;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_42065_SessionManager_A08 {
    private SecurityManager securityManager;

    public java_42065_SessionManager_A08() {
        this.securityManager = System.getSecurityManager();
    }

    public void runAsUser(final String username, final Runnable action) {
        if (securityManager == null) {
            action.run();
            return;
        }

        securityManager.doPrivileged(new PrivilegedAction<Object>() {
            @Override
            public Object runPrivileged(PrivilegedAction<Object> action) {
                try {
                    return action.run();
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e.getCause());
                }
            }
        }, new Permission[] { new RuntimePermission("user: " + username)});
    }
}