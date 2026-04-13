import java.util.HashMap;
import java.util.Map;

public class java_28986_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_28986_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already started with id: " + sessionId);
        }
        sessions.put(sessionId, new Session(sessionId));
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session started with id: " + sessionId);
        }
        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session started with id: " + sessionId);
        }
        sessions.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_28986_SessionManager_A03(String id) {
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