import java.lang.reflect.Method;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.Guard;
import java.security.Permission;
import java.security.Policy;
import java.util.HashSet;
import java.util.Set;

public class java_24644_SessionManager_A08 extends SecurityManager {
    private Set<String> permittedActions = new HashSet<>();

    public void addPermittedAction(String action) {
        permittedActions.add(action);
    }

    public void removePermittedAction(String action) {
        permittedActions.remove(action);
    }

    @Override
    public void checkPermission(Permission perm) {
        if (!permittedActions.contains(perm.getName())) {
            throw new SecurityException("Permission Denied: " + perm.getName());
        }
    }

    @Override
    public void checkPermission(Permission perm, Object target) {
        if (!permittedActions.contains(perm.getName())) {
            throw new SecurityException("Permission Denied: " + perm.getName());
        }
    }

    @Override
    public void checkPermission(Permission perm, Object target, Method method, Class<?> declaringClass) {
        if (!permittedActions.contains(perm.getName())) {
            throw new SecurityException("Permission Denied: " + perm.getName());
        }
    }

    public AccessControlContext setDefaultAccessControl(AccessControl accessControl) {
        return new AccessControlContext(this, accessControl, new Policy() {
            @Override
            public boolean implies(AccessControl other) {
                return true;
            }
        });
    }
}

public class SessionManager {
    private AccessControl accessControl;

    public java_24644_SessionManager_A08(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public void startSession() {
        CustomSecurityManager securityManager = new CustomSecurityManager();
        securityManager.setDefaultAccessControl(accessControl);

        // Adding the permitted actions here.
        securityManager.addPermittedAction("startSession");
        securityManager.addPermittedAction("closeSession");
        // Add more actions as needed

        // Replace the current SecurityManager with our custom one.
        System.setSecurityManager(securityManager);

        // Access to startSession and closeSession is permitted.
        startSession();
        closeSession();
    }

    public void closeSession() {
        // Your implementation here.
    }
}