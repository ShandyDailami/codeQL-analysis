import java.util.HashMap;
import java.util.Map;

public class java_05954_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_05954_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, new Session(sessionId, userId));
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String sessionId;
        private String userId;

        public java_05954_SessionManager_A01(String sessionId, String userId) {
            this.sessionId = sessionId;
            this.userId = userId;
        }

        // Getters and setters omitted for simplicity
    }
}