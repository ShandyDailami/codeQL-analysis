import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class java_40334_SessionManager_A01 {

    // ConcurrentHashMap to store sessions
    private final ConcurrentHashMap<String, Session> sessions = new ConcurrentHashMap<>();

    // Session class
    public class Session {
        private final String id;
        private final List<String> permissions = new ArrayList<>();

        public java_40334_SessionManager_A01(String id) {
            this.id = id;
        }

        public void addPermission(String permission) {
            permissions.add(permission);
        }

        public boolean hasPermission(String permission) {
            return permissions.contains(permission);
        }
    }

    // Add permission to session
    public void addPermissionToSession(String sessionId, String permission) {
        sessions.computeIfPresent(sessionId, (id, session) -> {
            session.addPermission(permission);
            return session;
        });
    }

    // Get session
    public Optional<Session> getSession(String sessionId) {
        return Optional.ofNullable(sessions.get(sessionId));
    }

    // Check if session has permission
    public boolean hasPermissionInSession(String sessionId, String permission) {
        return getSession(sessionId).map(session -> session.hasPermission(permission)).orElse(false);
    }

    // Check if session has permission
    public boolean hasPermissionInAnySession(String permission) {
        return sessions.values().stream().anyMatch(session -> session.hasPermission(permission));
    }
}