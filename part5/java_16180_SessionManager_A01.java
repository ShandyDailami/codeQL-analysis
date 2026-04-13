import java.util.HashMap;

public class java_16180_SessionManager_A01 {

    // Use a HashMap to store sessions
    private HashMap<String, Session> sessions;

    public java_16180_SessionManager_A01() {
        // Initialize the sessions map
        sessions = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, Session session) {
        sessions.put(sessionId, session);
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Inner class to represent a session
    public class Session {
        private String user;

        public java_16180_SessionManager_A01(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }
}