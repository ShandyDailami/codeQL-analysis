import java.util.HashMap;
import java.util.UUID;

public class java_03582_SessionManager_A03 {
    private HashMap<String, Session> sessions;

    public java_03582_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public class Session {
        private String id;

        public java_03582_SessionManager_A03(String id) {
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