import java.security.Permission;
import java.security.SecurityManager;
import java.security.UnsufficientPermissionException;

public class java_08852_SessionManager_A03 {
    private static final long SESSION_TIMEOUT = 60000; // 1 minute

    private static class MySecurityManager extends SecurityManager {
        @Override
        public void checkPermission(Permission perm) throws UnsufficientPermissionException {
            if (perm.getName().contains("close")) {
                throw new UnsufficientPermissionException("close method denied");
            }
        }
    }

    public static void main(String[] args) {
        // Create a new security manager with our custom permission
        SecurityManager sm = new MySecurityManager();

        // Set the new security manager
        System.setSecurityManager(sm);

        // Create a new session
        Session session = new Session(sessionId);

        // Use the session (session is now secure because of our security manager)
        // ...

        // Close the session
        session.close();
    }
}