import java.security.Permission;
import java.security.SecurityManager;
import java.util.HashSet;
import java.util.Set;

public class java_18141_SessionManager_A01 implements SecurityManager {
    private Set<Permission> permissions;

    public java_18141_SessionManager_A01() {
        permissions = new HashSet<>();
    }

    @Override
    public Set<Permission> getPermissions(Object o) {
        return permissions;
    }

    @Override
    public boolean grantPermission(Permission permission, Object o) {
        return permissions.add(permission);
    }

    @Override
    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_18141_SessionManager_A01() {
        securityManager = new CustomSecurityManager();
    }

    public void startSession() {
        if (securityManager.hasPermission(new RuntimePermission("startSession"))) {
            System.out.println("Starting session...");
        } else {
            System.out.println("Permission Denied: Start Session");
        }
    }

    public void endSession() {
        if (securityManager.hasPermission(new RuntimePermission("endSession"))) {
            System.out.println("Ending session...");
        } else {
            System.out.println("Permission Denied: End Session");
        }
    }
}