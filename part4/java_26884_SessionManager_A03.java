import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

public class java_26884_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_26884_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session startSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            Session session = new Session(sessionId);
            sessions.put(sessionId, session);
            return session;
        }
    }

    public Optional<Session> getSession(String sessionId) {
        return Optional.ofNullable(sessions.get(sessionId));
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String sessionId;

        public java_26884_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}