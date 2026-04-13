import java.util.HashMap;
import java.util.Map;

public class java_14703_SessionManager_A08 {
    // Using a HashMap to store sessions.
    // In a real application, a database would be more appropriate.
    private Map<String, Session> sessions;

    public java_14703_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            Session session = new Session(sessionId);
            sessions.put(sessionId, session);
            return session;
        }
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_14703_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}