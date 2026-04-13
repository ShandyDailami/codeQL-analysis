import java.util.HashMap;
import java.util.Map;

public class java_12378_SessionManager_A01 {
    // A map to hold our sessions. This could be replaced with a more complex data structure
    // like a database or other persistent storage.
    private Map<String, Session> sessions = new HashMap<>();

    // A Session is just a String id.
    public class Session {
        public String id;

        public java_12378_SessionManager_A01(String id) {
            this.id = id;
        }
    }

    // Create a new session.
    public Session createSession(String id) {
        Session session = new Session(id);
        sessions.put(id, session);
        return session;
    }

    // Get a session by its id.
    public Session getSession(String id) {
        return sessions.get(id);
    }

    // Invalidate a session by its id.
    public void invalidateSession(String id) {
        sessions.remove(id);
    }
}