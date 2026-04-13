import java.security.Permission;
import java.security.SecureRandom;
import java.security.SecurityException;

public class java_39504_SessionManager_A08 {

    private static SecureRandom sr = new SecureRandom();

    // Permission to check the session
    private static class CheckSessionPermission extends Permission {
        CheckSessionPermission() {
            super("session check");
        }
        @Override
        public void invoke(SecurityManager securityManager, String action) {
            if (!"checkSession".equals(action))
                throw new IllegalArgumentException("Invalid action");
            if (securityManager == null)
                throw new SecurityException("No security manager");
            securityManager.checkPermission(new CheckSessionPermission());
        }
    }

    private static class CheckAccessPermission extends Permission {
        CheckAccessPermission() {
            super("access check");
        }
        @Override
        public void invoke(SecurityManager securityManager, String action) {
            if (!"checkAccess".equals(action))
                throw new IllegalArgumentException("Invalid action");
            if (securityManager == null)
                throw new SecurityException("No security manager");
            securityManager.checkPermission(new CheckAccessPermission());
        }
    }

    private SecurityManager securityManager = new SecurityManager() {
        @Override
        public void checkPermission(Permission permission) throws SecurityException {
            if ("session check".equals(permission.getName()) && !checkSession()) {
                throw new SecurityException("Session check failed");
            }
            if ("access check".equals(permission.getName()) && !checkAccess()) {
                throw new SecurityException("Access check failed");
            }
        }

        private boolean checkSession() {
            // Check the session here
            // This can be any sensitive operation
            return true;
        }

        private boolean checkAccess() {
            // Check the access here
            // This can be any sensitive operation
            return true;
        }
    };

    private String sessionID;

    public java_39504_SessionManager_A08() {
        // Generate a session ID
        sessionID = sr.nextInt(999999) + "";
    }

    public String getSessionID() {
        return sessionID;
    }

    public SecurityManager getSecurityManager() {
        return securityManager;
    }
}