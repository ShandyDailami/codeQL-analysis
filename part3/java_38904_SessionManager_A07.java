import java.util.HashMap;
import java.util.Map;

public class java_38904_SessionManager_A07 {
    private Map<String, Session> sessionMap;

    public java_38904_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_38904_SessionManager_A07(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}