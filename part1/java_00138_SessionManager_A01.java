import java.util.HashMap;
import java.util.Map;

public class java_00138_SessionManager_A01 {
    // Use a HashMap for this example, in a real application you might use a database
    private Map<String, Session> sessions;

    public java_00138_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session startSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            sessions.put(sessionId, new Session(sessionId));
        }
        return sessions.get(sessionId);
    }

    public Session beginSession(String sessionId) {
        Session session = startSession(sessionId);
        session.begin();
        return session;
    }

    public void endSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.end();
            sessions.remove(sessionId);
        }
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    // Session class for managing a session
    private class Session {
        private String sessionId;
        private boolean active;

        public java_00138_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
            active = false;
        }

        public void begin() {
            active = true;
        }

        public void end() {
            active = false;
        }

        public String getSessionId() {
            return sessionId;
        }

        public boolean isActive() {
            return active;
        }
    }
}