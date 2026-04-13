import java.security.AccessControl;
import java.security.AccessControlListener;
import java.security.AccessControlContext;
import java.security.Permission;
import java.security.SecurityPermission;
import java.util.HashSet;
import java.util.Set;

public class java_19512_SessionManager_A01 extends SecurityManager {
    private Set<String> permittedActions;

    public java_19512_SessionManager_A01(Set<String> permittedActions) {
        this.permittedActions = permittedActions;
    }

    @Override
    public void checkPermission(Permission perm) throws SecurityException {
        if (!permittedActions.contains(perm.getName())) {
            throw new SecurityException("Permission " + perm.getName() + " not permitted");
        }
    }

    @Override
    public void checkPermissions(Set<Permission> perms) throws SecurityException {
        Set<String> permissionNames = new HashSet<>();
        for (Permission perm : perms) {
            permissionNames.add(perm.getName());
        }
        if (!permissionNames.containsAll(permittedActions)) {
            throw new SecurityException("Permissions not permitted");
        }
    }
}

public class MySessionContext {
    private Object context;

    public java_19512_SessionManager_A01(Object context) {
        this.context = context;
    }

    public Object getContext() {
        return context;
    }

    public void setContext(Object context) {
        this.context = context;
    }
}

public class MySessionFactory {
    private AccessControl accessControl;

    public java_19512_SessionManager_A01(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public MySessionContext openSession() {
        if (accessControl.checkPermission(new SecurityPermission("openSession"))) {
            return new MySessionContext(new Object());
        } else {
            throw new SecurityException("Session opening failed");
        }
    }
}

public class MyApp {
    public static void main(String[] args) {
        Set<String> permittedActions = new HashSet<>();
        permittedActions.add("openSession");

        AccessControl accessControl = new AccessControl() {
            @Override
            public AccessControlContext getAccessControlContext() {
                return new MySecurityManager(permittedActions);
            }
        };

        MySessionFactory sessionFactory = new MySessionFactory(accessControl);
        MySessionContext sessionContext = sessionFactory.openSession();
        System.out.println(sessionContext.getContext());
    }
}