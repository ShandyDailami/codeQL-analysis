import java.util.HashMap;

public class java_07583_SessionManager_A01 {

    private HashMap<String, Session> sessions;

    public java_07583_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        if (this.sessions.containsKey(userId)) {
            throw new IllegalStateException("Session already exists for user: " + userId);
        }

        Session session = new Session(userId);
        this.sessions.put(userId, session);
        return session.getId();
    }

    public Session getSession(String userId) {
        if (!this.sessions.containsKey(userId)) {
            throw new IllegalStateException("No session exists for user: " + userId);
       
        return this.sessions.get(userId);
    }

    public void destroySession(String userId) {
        if (!this.sessions.containsKey(userId)) {
            throw new IllegalStateException("No session exists for user: " + userId);
        }

        this.sessions.remove(userId);
    }

    private class Session {

        private String id;

        public java_07583_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}