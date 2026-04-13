import java.security.Permission;
import java.security.PermissionCollection;
import java.security.SecureClassLoadingPermission;
import java.security.SecurityPermission;

public class java_23204_SessionManager_A03 {

    private String sessionId;

    public java_23204_SessionManager_A03() {
        sessionId = "InitialSession";
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    // This is a custom permission for demonstration purposes only.
    private static class CustomSecurityPermission extends SecurityPermission {
        private static final long serialVersionUID = 1;

        CustomSecurityPermission(String s) {
            super(s);
        }
    }

    public static void main(String[] args) {
        try {
            // Create a new SessionManager
            SessionManager sessionManager = new SessionManager();

            // Use reflection to change the sessionId (to demonstrate injection)
            sessionManager.setSessionId("CustomSession");

            // Print the sessionId
            System.out.println("Session ID: " + sessionManager.getSessionId());

            // Create a new permission collection
            PermissionCollection permissionCollection = new PermissionCollection();

            // Add a new custom permission
            permissionCollection.add(new CustomSecurityPermission("SessionManagerPermission"));

            // Check if the system has permission to change the session ID
            if (!java.security.Security.getCurrentSecurityManager().checkPermission(permissionCollection)) {
                System.out.println("Permission denied");
            } else {
                System.out.println("Permission granted");
            }

        } catch (SecurityException e) {
            System.out.println("Caught SecurityException: " + e.getMessage());
        }
    }
}