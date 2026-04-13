import java.util.HashMap;
import java.util.Map;

public class java_11393_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_11393_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String startSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public void endSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
        }
    }

    private class Session {
        private String id;

        public java_11393_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}