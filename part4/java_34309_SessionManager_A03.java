import java.util.HashMap;
import java.util.UUID;

public class java_34309_SessionManager_A03 {
    private HashMap<String, Session> sessions;

    public java_34309_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return null;
        }
    }

    public class Session {
        private String id;

        public java_34309_SessionManager_A03(String id) {
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