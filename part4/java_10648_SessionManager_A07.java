import java.security.SecurityPermission;
import java.security.Permission;
import java.security.ProtectionDomain;

// A simple SecurityManager that allows all actions
public class java_10648_SessionManager_A07 extends SecurityManager {
    public void checkPermission(Permission perm) {
    }

    public void checkPermission(Permission perm, Object target) {
    }

    public void checkMember(String member, ProtectionDomain domain) {
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_10648_SessionManager_A07() {
        // Create a new SimpleSecurityManager
        securityManager = new SimpleSecurityManager();
    }

    public void startSession(String username) {
        // Check if the username is valid
        if (username != null && !username.isEmpty()) {
            securityManager.checkMember(username, null);
        } else {
            throw new SecurityException("Invalid username");
        }

        // Session starts here...
    }

    public void endSession() {
        // Session ends here...
    }
}