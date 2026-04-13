import java.util.HashMap;
import java.util.Map;

public class java_05952_SessionManager_A08 {
    private Map<String, Session> sessionMap;

    public java_05952_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        Session session = new Session(sessionId, new HashMap<>());
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setAttribute(String sessionId, String attributeId, Object attributeValue) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            session.getAttributes().put(attributeId, attributeValue);
        }
    }

    public Object getAttribute(String sessionId, String attributeId) {
        Session session = sessionMap.get(sessionId);
        return (session != null ? session.getAttributes().get(attributeId) : null);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static class Session {
        private String sessionId;
        private Map<String, Object> attributes;

        public java_05952_SessionManager_A08(String sessionId, Map<String, Object> attributes) {
            this.sessionId = sessionId;
            this.attributes = attributes;
        }

        public String getSessionId() {
            return sessionId;
        }

        public Map<String, Object> getAttributes() {
            return attributes;
        }
    }
}