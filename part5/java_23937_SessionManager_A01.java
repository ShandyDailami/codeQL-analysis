import java.security.Permission;
import java.security.SecurityPermission;
import java.util.ArrayList;
import java.util.List;

public class java_23937_SessionManager_A01 {
    // List to store sessions
    private List<Session> sessions = new ArrayList<>();

    // Minimum and maximum idle time in seconds
    private int minIdleTime = 5;
    private int maxIdleTime = 60;

    // SecurityManager instance
    private SecurityManager securityManager;

    public java_23937_SessionManager_A01() {
        // Initialize SecurityManager
        securityManager = System.getSecurityManager();
        if (securityManager == null) {
            throw new RuntimeException("Unable to locate SecurityManager");
        }
    }

    public void startSession(String sessionId) {
        // Ensure SecurityManager exists
        if (securityManager == null) {
            throw new RuntimeException("Unable to locate SecurityManager");
        }

        // Check permission to create a session
        Permission permission = new SecurityPermission("session.create");
        securityManager.checkPermission(permission);

        // Create a new session
        Session session = new Session(sessionId);
        sessions.add(session);
    }

    public void endSession(String sessionId) {
        // Remove the session from the list
        sessions.removeIf(session -> session.getId().equals(sessionId));
    }

    public void maintainSession(String sessionId) {
        // Find the session
        Session session = sessions.stream()
                .filter(s -> s.getId().equals(sessionId))
                .findFirst()
                .orElse(null);

        // If session exists, update its idle time
        if (session != null) {
            session.setLastAccessed(System.currentTimeMillis());
        }
    }

    // Session class
    private class Session {
        private String id;
        private long lastAccessed;

        public java_23937_SessionManager_A01(String id) {
            this.id = id;
            this.lastAccessed = System.currentTimeMillis();
        }

        public String getId() {
            return id;
        }

        public long getLastAccessed() {
            return lastAccessed;
        }

        public void setLastAccessed(long lastAccessed) {
            this.lastAccessed = lastAccessed;
        }
    }
}