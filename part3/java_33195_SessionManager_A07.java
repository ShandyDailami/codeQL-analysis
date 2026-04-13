import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_33195_SessionManager_A07 extends SecurityManager {

    public static class CreateSessionAction implements PrivilegedAction<Session> {
        public Session run() {
            return Session.getInstance(new Configuration());
        }
    }

    public Session newSession() {
        return ((Session) invoke(new CreateSessionAction()));
    }

    public void checkCreateSession(Session session, String securityRealm) {
        // No-op
    }

    public void checkPermission(Permission perm, Object context) {
        // No-op
    }

    public void checkPermission(Permission perm) {
        // No-op
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a custom security manager
        SecurityManager sm = new CustomSecurityManager();

        // Set the security manager
        System.setSecurityManager(sm);

        // Create a new session
        Session session = sm.newSession();

        // Use the session...
    }
}