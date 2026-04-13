import java.util.HashMap;
import java.util.Map;

public class java_22201_SessionManager_A03 {
    private Map<String, Session> sessionMap;

    public java_22201_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessionMap.put(sessionId, session);
        }
        return session;
    }

    public class Session {
        private String sessionId;

        public java_22201_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}