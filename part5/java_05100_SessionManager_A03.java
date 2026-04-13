import java.util.HashMap;
import java.util.Map;

public class java_05100_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_05100_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession() {
        String sessionId = generateSessionId();
        sessions.put(sessionId, new Session(sessionId));
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        // Here we can use UUID or other methods to generate a unique session ID
        // For the sake of simplicity, we'll just generate a random string
        return java.util.UUID.randomUUID().toString();
    }

    private class Session {
        private String sessionId;

        public java_05100_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}