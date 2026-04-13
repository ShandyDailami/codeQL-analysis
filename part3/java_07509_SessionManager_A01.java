import java.util.HashMap;
import java.util.Map;

public class java_07509_SessionManager_A01 {

    private Map<String, Session> sessionMap;

    public java_07509_SessionManager_A01() {
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

    public class Session {

        private String id;

        public java_07509_SessionManager_A01(String id) {
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