import java.util.ArrayList;
import java.util.List;

public class java_19339_SessionManager_A01 {
    private List<String> permissions;

    public java_19339_SessionManager_A01() {
        permissions = new ArrayList<>();
    }

    public void addPermission(String permission) {
        permissions.add(permission);
    }

    public boolean hasPermission(String permission) {
        return permissions.contains(permission);
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_19339_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void startSession(String permission) {
        if (!securityManager.hasPermission(permission)) {
            throw new SecurityException("Permission denied");
        }
        // Start session...
    }

    public void endSession() {
        // End session...
    }
}