import java.util.HashMap;
import java.util.Map;

public class java_24808_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_24808_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, new Session(sessionId));
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_24808_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}