import java.util.Map;
import java.util.HashMap;

public class java_25038_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_25038_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void createSession(String sessionId) {
        sessions.put(sessionId, new Session(sessionId));
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public class Session {
        private String id;

        public java_25038_SessionManager_A07(String id) {
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