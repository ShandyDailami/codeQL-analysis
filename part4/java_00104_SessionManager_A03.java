import java.util.HashMap;

public class java_00104_SessionManager_A03 {

    private HashMap<String, Session> sessions;

    public java_00104_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        Session session = new Session();
        String sessionId = session.getId();
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public class Session {

        private String id;

        public String getId() {
            // You could use a cryptographic method here to generate a random ID
            // This is just a placeholder
            id = "session_id";
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }
}