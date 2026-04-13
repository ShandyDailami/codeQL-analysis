import java.security.Permission;
import java.security.SecurityPermission;
import java.util.HashSet;
import java.util.Set;

public class java_26878_SessionManager_A01 extends SecurityManager {

    private Set<Permission> permissions;

    public java_26878_SessionManager_A01() {
        this.permissions = new HashSet<>();
    }

    public void checkPermission(Permission perm) {
        if (perm instanceof SecurityPermission) {
            throw new SecurityException("Operation not permitted");
        }
        permissions.add(perm);
    }

    public void checkPermissions(Set<Permission> perms) {
        if (perms.contains(new SecurityPermission("operation not permitted"))) {
            throw new SecurityException("Operation not permitted");
        }
        permissions.addAll(perms);
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}

public class SessionManager {

    private CustomSecurityManager securityManager;

    public java_26878_SessionManager_A01() {
        securityManager = new CustomSecurityManager();
    }

    public CustomSecurityManager getSecurityManager() {
        return securityManager;
    }

    public void startSession() {
        securityManager.checkPermission(new SecurityPermission("startSession"));
        // Rest of the session logic goes here
    }

    public void endSession() {
        securityManager.checkPermission(new SecurityPermission("endSession"));
        // Rest of the session logic goes here
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.getSecurityManager().checkPermission(new SecurityPermission("accessSession"));
        // Rest of the program logic goes here
    }
}