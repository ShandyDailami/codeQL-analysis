import java.util.HashMap;
import java.util.Map;

public class java_28896_SessionManager_A08 {
    private Map<String, Session> sessionMap;

    public java_28896_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            Session session = new Session(sessionId);
            sessionMap.put(sessionId, session);
        }
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Session class not shown for simplicity
    public static class Session {
        private String sessionId;

        public java_28896_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        // Add methods for session here
    }
}