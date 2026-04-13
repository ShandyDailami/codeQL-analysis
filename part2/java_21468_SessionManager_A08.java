import java.security.Permission;
import java.security.SecurityException;

public class java_21468_SessionManager_A08 {
    private static final String[] actions = { "createSession", "closeSession" };

    public static class SessionCreationPermission implements Permission {
        public String getActions() {
            return actions[0];
        }

        public boolean implies(Permission other) {
            if (!(other instanceof SessionCreationPermission))
                return false;
            return true;
        }

        public void checkPermission() throws SecurityException {
            throw new SecurityException("Insecure operation: " + actions[0]);
        }
    }

    public static class SessionDestructionPermission implements Permission {
        public String getActions() {
            return actions[1];
        }

        public boolean implies(Permission other) {
            if (!(other instanceof SessionDestructionPermission))
                return false;
            return true;
        }

        public void checkPermission() throws SecurityException {
            throw new SecurityException("Insecure operation: " + actions[1]);
        }
    }

    public java_21468_SessionManager_A08() {
        System.loadLibrary("sessionmanager");
    }

    public void createSession() {
        Permission permission = new SessionCreationPermission();
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null)
            throw new RuntimeException("SecurityManager not available");
        try {
            securityManager.checkPermission(permission);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        nativeCreateSession();
    }

    public void closeSession() {
        Permission permission = new SessionDestructionPermission();
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null)
            throw new RuntimeException("SecurityManager not available");
        try {
            securityManager.checkPermission(permission);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        nativeCloseSession();
    }

    private native void nativeCreateSession();

    private native void nativeCloseSession();

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession();
        sessionManager.closeSession();
    }
}