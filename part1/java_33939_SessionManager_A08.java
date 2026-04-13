import java.util.HashMap;
import java.util.Map;

public class java_33939_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_33939_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        Session session = new Session();
        sessions.put(session.getId(), session);
        return session;
    }

    public Session getSession(String id) {
        return sessions.get(id);
    }

    public void destroySession(String id) {
        sessions.remove(id);
    }

    public static class Session {
        private String id;

        public java_33939_SessionManager_A08() {
            this.id = UUID.randomUUID().toString(); // create a new session id
        }

        public String getId() {
            return id;
        }
    }
}