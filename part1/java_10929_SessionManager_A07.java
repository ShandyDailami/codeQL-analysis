import java.security.AuthPermission;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.UnresolvedPermission;
import java.util.HashSet;
import java.util.Set;

public class java_10929_SessionManager_A07 {
    private static SessionManager instance;
    private Set<String> authorizedSessions;

    private java_10929_SessionManager_A07() {
        authorizedSessions = new HashSet<>();
        // Set the initial list of authorized sessions.
        authorizedSessions.add("session1");
        authorizedSessions.add("session2");
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
            // Initialize the SecurityManager with our SessionManager.
            SecurityManager sm = new SecurityManager() {
                @Override
                public void checkPermission(Permission perm) throws UnresolvedPermission {
                    if (instance.authorizedSessions.contains(perm.getName())) {
                        super.checkPermission(perm);
                    } else {
                        throw new UnresolvedPermission(perm);
                    }
                }

                @Override
                public void checkPermission(Permission perm, Object context) throws UnresolvedPermission {
                    if (instance.authorizedSessions.contains(perm.getName())) {
                        super.checkPermission(perm, context);
                    } else {
                        throw new UnresolvedPermission(perm, context);
                    }
                }
            };
            System.setSecurityManager(sm);
        }
        return instance;
    }

    public void startSession(String sessionId) {
        if (authorizedSessions.contains(sessionId)) {
            System.out.println("Starting session: " + sessionId);
        } else {
            System.out.println("Unauthorized attempt to start session: " + sessionId);
        }
    }
}