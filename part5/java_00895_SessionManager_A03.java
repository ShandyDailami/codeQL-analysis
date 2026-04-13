import java.util.HashMap;
import java.util.Map;

public class java_00895_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_00895_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Session with ID " + sessionId + " already exists.";
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return "Session with ID " + sessionId + " has been created.";
    }

    public String destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            return "No session with ID " + sessionId + " exists.";
        }

        sessions.remove(sessionId);

        return "Session with ID " + sessionId + " has been destroyed.";
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    private class Session {
        private String id;

        public java_00895_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}