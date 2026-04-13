import java.util.HashMap;
import java.util.Map;

public class java_27052_SessionManager_A01 {

    private Map<String, Session> sessionMap;

    public java_27052_SessionManager_A01() {
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

    private class Session {
        private String id;

        public java_27052_SessionManager_A01(String id) {
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