import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_09237_SessionManager_A03 {
    // Use a ConcurrentHashMap for thread safety
    private final Map<String, Session> sessions;

    public java_09237_SessionManager_A03() {
        sessions = new ConcurrentHashMap<>();
    }

    public Session getSession(String sessionId) {
        // Check if the session exists
        if (!sessions.containsKey(sessionId)) {
            // Create a new session if it doesn't exist
            sessions.put(sessionId, new Session(sessionId));
        }

        // Return the session
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        // Remove the session from the map
        sessions.remove(sessionId);
    }

    private class Session {
        private final String id;

        public java_09237_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}