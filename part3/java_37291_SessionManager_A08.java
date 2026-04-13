import java.security.Permission;
import java.security.SecurityManager;
import java.util.HashMap;
import java.util.Map;

public class java_37291_SessionManager_A08 implements SecurityManager {
    private Map<String, Permission> permissions = new HashMap<>();

    public java_37291_SessionManager_A08() {
        // Add the permissions here
        Permission permission = new Permission("A08_IntegrityFailure");
        permissions.put("read", permission);
        permissions.put("write", permission);
    }

    @Override
    public boolean checkPermission(Permission p) {
        return permissions.containsKey(p.getName());
    }

    @Override
    public void checkPermissions(Map<String, Permission> permissions) {
        // Here you can implement the logic for checking multiple permissions
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_37291_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void createSession(String sessionName) {
        if (securityManager.checkPermission(new Permission("read"))) {
            System.out.println("Creating session: " + sessionName);
        } else {
            System.out.println("Permission denied to create session.");
        }
    }

    public void endSession(String sessionName) {
        if (securityManager.checkPermission(new Permission("write"))) {
            System.out.println("Ending session: " + sessionName);
        } else {
            System.out.println("Permission denied to end session.");
        }
    }
}