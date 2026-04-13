import java.util.HashMap;
import java.util.Map;

public class java_12942_SessionManager_A03 {
    private Map<String, Session> sessions;

    // Constructor
    public java_12942_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to get a session
    public Session getSession(String id) {
        Session session = sessions.get(id);
        if (session == null) {
            session = new Session(id);
            sessions.put(id, session);
        }
        return session;
    }

    // Session class
    public class Session {
        private String id;

        public java_12942_SessionManager_A03(String id) {
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