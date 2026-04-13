import java.util.HashMap;
import java.util.Map;

public class java_13000_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_13000_SessionManager_A03() {
        this.sessions = new HashMap<>();
    }

    public Session createSession() {
        String sessionId = UUID.randomUUID().toString(); // Assuming UUID for session id
        Session session = new Session(sessionId);
        this.sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return this.sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        this.sessions.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_13000_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}