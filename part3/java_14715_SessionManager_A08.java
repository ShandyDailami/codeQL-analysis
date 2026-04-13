import java.util.HashMap;
import java.util.Map;

public class java_14715_SessionManager_A08 {

    private Map<String, Session> sessionMap;

    public java_14715_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(Session session) {
        String sessionId = session.getId();
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_14715_SessionManager_A08(String id) {
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