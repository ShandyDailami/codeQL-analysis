import java.util.HashMap;
import java.util.Map;

public class java_36946_SessionManager_A07 implements SessionManager {

    private Map<String, Session> sessionMap;

    public java_36946_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    @Override
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    @Override
    public void createSession(String sessionId) {
        sessionMap.put(sessionId, new Session(sessionId));
    }

    @Override
    public void updateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, new Session(sessionId));
        }
    }

    @Override
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_36946_SessionManager_A07(String id) {
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