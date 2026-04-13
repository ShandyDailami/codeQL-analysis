import java.util.HashMap;

public class java_18946_SessionManager_A07 {

    private HashMap<String, Session> sessions;

    public java_18946_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession() {
        Session session = new Session();
        String sessionId = session.getId();
        sessions.put(sessionId, session);
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    private class Session {
        private String id;

        public String getId() {
            // Generate a unique ID for the session
            id = "A07_" + System.currentTimeMillis();
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}