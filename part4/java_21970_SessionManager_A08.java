import java.security.Permission;
import java.security.SecurityManager;

public class java_21970_SessionManager_A08 {
    private SecurityManager securityManager;

    public java_21970_SessionManager_A08() {
        // Initialize the security manager
        securityManager = System.getSecurityManager();

        if (securityManager == null) {
            // No security manager set, create a new one
            securityManager = new SecurityManager() {
                @Override
                public void checkPermission(Permission perm) {
                    // Check for permission denial at runtime
                    throw new SecurityException("Permission denied: " + perm);
                }
            };

            // Set the security manager
            System.setSecurityManager(securityManager);
        }
    }

    public void createSession(String sessionId) {
        // Check the security manager before creating a session
        securityManager.checkPermission(new java.security.Permission("createSession"));

        // Create a session
        System.out.println("Created session with ID: " + sessionId);
    }
}